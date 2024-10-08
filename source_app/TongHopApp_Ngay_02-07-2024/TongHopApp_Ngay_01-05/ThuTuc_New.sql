SELECT * FROM DETHI;
SELECT * FROM NV001.KETQUA;

CREATE OR REPLACE PROCEDURE KetQua_SelectAll
(
    C_cursor OUT SYS_REFCURSOR
)
AS
    v_huy BOOLEAN;
BEGIN
    -- Ki?m tra n?u tên ng??i dùng b?t ??u b?ng "NV"
    v_huy := (SYS_CONTEXT('USERENV', 'SESSION_USER') LIKE 'NV%');

    -- M? con tr? d?a trên chính sách VPD
    IF v_huy THEN
        OPEN C_cursor FOR
        SELECT * FROM NV001.KETQUA;
    ELSE
        OPEN C_cursor FOR
        SELECT * FROM NV001.KETQUA WHERE MaHocSinh = SYS_CONTEXT('USERENV', 'SESSION_USER');
    END IF;
END KetQua_SelectAll;
COMMIT;

CREATE OR REPLACE PROCEDURE CongNo_SelectAll
(
    C_cursor OUT SYS_REFCURSOR
)
AS
    v_huy BOOLEAN;
BEGIN
    -- Kiem tra neu tên nguoi dùng bat dau bang "NV"
    v_huy := (SYS_CONTEXT('USERENV', 'SESSION_USER') LIKE 'NV%');

    -- M? con tr? d?a trên chính sách VPD
    IF v_huy THEN
        OPEN C_cursor FOR
        SELECT * FROM NV001.CONGNO;
    ELSE
        OPEN C_cursor FOR
        SELECT * FROM NV001.CONGNO WHERE MaHS = SYS_CONTEXT('USERENV', 'SESSION_USER');
    END IF;
END CongNo_SelectAll;
COMMIT;

CREATE OR REPLACE PROCEDURE MonHoc_SelectAll--DANG DUNG BEN WEB 
(
    C_cursor OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN C_cursor FOR
    Select * from NV001.MONHOC;
END MonHoc_SelectAll;
COMMIT;

CREATE OR REPLACE PROCEDURE DeThi_Where_MaMonHoc
(
    maMonHoc IN NVARCHAR2,
    C_cursor OUT SYS_REFCURSOR
)
AS
    v_huy BOOLEAN;
BEGIN
    v_huy := (SYS_CONTEXT('USERENV', 'SESSION_USER') LIKE 'NV%');
    
    IF v_huy THEN
        OPEN C_cursor FOR
        SELECT * FROM NV001.DeThi WHERE MaMH = maMonHoc;
    ELSE
        OPEN C_cursor FOR
        SELECT * FROM NV001.DeThi WHERE MaMH = maMonHoc AND TrangThaiTruyCapDe = 'M?';
    END IF;
END DeThi_Where_MaMonHoc;
COMMIT;

CREATE OR REPLACE PROCEDURE CauHoi_Where_MaDeThi
(
    maDeThi IN NVARCHAR2, -- Tham s? ??u vào cho MaDeThi
    C_cursor OUT SYS_REFCURSOR
)
AS
    v_MaDeThi NVARCHAR2(50); -- Bi?n t?m th?i
BEGIN
    v_MaDeThi := maDeThi;
    
    OPEN C_cursor FOR
    SELECT * FROM NV001.CauHoi 
    WHERE MaMH IN (SELECT MaMH FROM NV001.DeThi WHERE MADETHI = v_MaDeThi);
END CauHoi_Where_MaDeThi;
/
SELECT * FROM NV001.CauHoi WHERE MaMH IN (SELECT MaMH FROM NV001.DeThi WHERE MADETHI = 'DETHI-0001');--test

CREATE OR REPLACE PROCEDURE DeThi_SelectAll--DANG DUNG BEN WEB 
(
    C_cursor OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN C_cursor FOR
    Select * from NV001.DeThi;
END DeThi_SelectAll;
COMMIT;

CREATE OR REPLACE PROCEDURE CauHoi_Select_DapAnDung
(
    maCauHoi IN NVARCHAR2, -- Input parameter for MaCauHoi
    C_cursor OUT SYS_REFCURSOR
)
AS
    v_MaCauHoi NVARCHAR2(50); -- Bi?n t?m th?i
BEGIN
    v_MaCauHoi := maCauHoi;
    
    OPEN C_cursor FOR
    SELECT DapAnDung FROM NV001.CauHoi WHERE MaCauHoi = v_MaCauHoi;
END CauHoi_Select_DapAnDung;
/
CREATE OR REPLACE PROCEDURE ThoiGianThi_Where_MaDeThi
(
    maDeThi IN NVARCHAR2, -- Input parameter for MaDeThi
    C_cursor OUT SYS_REFCURSOR
)
AS
    v_MaDeThi NVARCHAR2(50); -- Bi?n t?m th?i
BEGIN
    v_MaDeThi := maDeThi;
    
    OPEN C_cursor FOR
    SELECT DISTINCT ThoiGianThi FROM ChiTietDeThi WHERE MaDeThi = v_MaDeThi;
END ThoiGianThi_Where_MaDeThi;
/
CREATE OR REPLACE PROCEDURE v1_DiemDanh_SelectAll
(
    C_cursor OUT SYS_REFCURSOR
)
AS
    v_kiemtra BOOLEAN;
BEGIN
    -- Kiem tra neu ten nguoi dung bat dau bang 'NV'
    v_kiemtra := (SYS_CONTEXT('USERENV', 'SESSION_USER') LIKE 'NV%');

    IF v_kiemtra THEN
        OPEN C_cursor FOR
        SELECT * FROM NV001.DIEMDANH;
    ELSE
        OPEN C_cursor FOR
        SELECT * FROM NV001.DIEMDANH WHERE MaHS = SYS_CONTEXT('USERENV', 'SESSION_USER');
    END IF;
END v1_DiemDanh_SelectAll;
/
COMMIT;
CREATE OR REPLACE PROCEDURE GetKhauPhanDaDangKi
(
    C_cursor OUT SYS_REFCURSOR
)
AS
    v_huy BOOLEAN;
BEGIN
    -- Ki?m tra n?u tên ng??i dùng b?t ??u b?ng "NV"
    v_huy := (SYS_CONTEXT('USERENV', 'SESSION_USER') LIKE 'NV%');

    -- M? con tr? d?a trên chính sách VPD
    IF v_huy THEN
        OPEN C_cursor FOR
        SELECT * FROM NV001.DangKyKhauPhanAn;
    ELSE
        OPEN C_cursor FOR
        SELECT * FROM NV001.DangKyKhauPhanAn WHERE MaHS = SYS_CONTEXT('USERENV', 'SESSION_USER');
    END IF;
END GetKhauPhanDaDangKi;
COMMIT;
CREATE OR REPLACE PROCEDURE LayThongTinDangKiCur(
    p_macombo IN VARCHAR2,
    p_thutrongtuan OUT INT,
    p_giatien OUT FLOAT,
    p_qrcode OUT VARCHAR2
) AS
    CURSOR combo_cursor IS
        SELECT thutrongtuan, giatien, qrcode
        FROM NV001.combomonan
        WHERE macombomon = p_macombo;
    
    l_thutrongtuan NV001.combomonan.thutrongtuan%TYPE;
    l_giatien NV001.combomonan.giatien%TYPE;
    l_qrcode NV001.combomonan.qrcode%TYPE;
BEGIN
    OPEN combo_cursor;
    FETCH combo_cursor INTO l_thutrongtuan, l_giatien, l_qrcode;

    IF combo_cursor%NOTFOUND THEN
        -- Handle the case when no data is found
        p_thutrongtuan := NULL;
        p_giatien := NULL;
        p_qrcode := NULL;
    ELSE
        -- Assign the fetched values to the OUT parameters
        p_thutrongtuan := l_thutrongtuan;
        p_giatien := l_giatien;
        p_qrcode := l_qrcode;
    END IF;
    
    CLOSE combo_cursor;
END LayThongTinDangKiCur;
/
COMMIT;
CREATE OR REPLACE PROCEDURE GetComboMonan (
    comboMonan OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN comboMonan FOR
    SELECT macombomon, loaicombomon, tenmon1, tenmon2, tenmon3, tenmon4, thutrongtuan, giatien, qrcode
    FROM NV001.combomonan;
END;
COMMIT;

SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE CreateProfile (
    p_profile_name          IN VARCHAR2,
    p_failed_login_attempts IN NUMBER,
    p_sessions_per_user     IN NUMBER,
    p_connect_time          IN NUMBER,
    p_idle_time             IN NUMBER,
    p_password_lock_time    IN NUMBER
) IS
BEGIN
    EXECUTE IMMEDIATE 'CREATE PROFILE ' || p_profile_name || ' LIMIT ' ||
                      'FAILED_LOGIN_ATTEMPTS ' || p_failed_login_attempts || ' ' ||
                      'SESSIONS_PER_USER ' || p_sessions_per_user || ' ' ||
                      'CONNECT_TIME ' || p_connect_time || ' ' ||
                      'IDLE_TIME ' || p_idle_time || ' ' ||
                      'PASSWORD_LOCK_TIME ' || p_password_lock_time;
    
    DBMS_OUTPUT.PUT_LINE('Profile ' || p_profile_name || ' created successfully.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END CreateProfile;
/
BEGIN
    CreateProfile('NhanVienTEST',3,3,45,5,5);
END;
/
CREATE OR REPLACE PROCEDURE DropProfile (
    p_profile_name IN VARCHAR2
) AS
BEGIN
    EXECUTE IMMEDIATE 'DROP PROFILE ' || p_profile_name;
    DBMS_OUTPUT.PUT_LINE('Profile ' || p_profile_name || ' dropped successfully.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END DropProfile;
/
CREATE OR REPLACE PROCEDURE UpdateProfile (
    p_profile_name          IN VARCHAR2,
    p_failed_login_attempts IN NUMBER,
    p_sessions_per_user     IN NUMBER,
    p_connect_time          IN NUMBER,
    p_idle_time             IN NUMBER,
    p_password_lock_time    IN NUMBER
) IS
BEGIN
    EXECUTE IMMEDIATE 'ALTER PROFILE ' || p_profile_name || ' LIMIT ' ||
                      'FAILED_LOGIN_ATTEMPTS ' || p_failed_login_attempts || ' ' ||
                      'SESSIONS_PER_USER ' || p_sessions_per_user || ' ' ||
                      'CONNECT_TIME ' || p_connect_time || ' ' ||
                      'IDLE_TIME ' || p_idle_time || ' ' ||
                      'PASSWORD_LOCK_TIME ' || p_password_lock_time;            
    DBMS_OUTPUT.PUT_LINE('Profile ' || p_profile_name || ' cap nhat thanh cong.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('That bai vs loi: ' || SQLERRM);
END UpdateProfile;
/

SELECT PROFILE, RESOURCE_NAME, RESOURCE_TYPE, LIMIT
FROM DBA_PROFILES
WHERE PROFILE != 'DEFAULT' AND PROFILE != 'ORA_STIG_PROFILE'
ORDER BY PROFILE, RESOURCE_NAME;

SELECT USERNAME, PROFILE
FROM DBA_USERS
WHERE PROFILE != 'DEFAULT';

CREATE OR REPLACE PROCEDURE SelectAll_Profile
(
    C_cursor OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN C_cursor FOR
    SELECT PROFILE, RESOURCE_NAME, RESOURCE_TYPE, LIMIT
    FROM DBA_PROFILES
    WHERE PROFILE != 'DEFAULT' AND PROFILE != 'ORA_STIG_PROFILE'
    ORDER BY PROFILE, RESOURCE_NAME;
END SelectAll_Profile;
COMMIT;
CREATE OR REPLACE PROCEDURE SelectAll_User_Profile
(
    C_cursor OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN C_cursor FOR
    SELECT USERNAME, PROFILE
    FROM DBA_USERS
    WHERE PROFILE != 'DEFAULT';
END SelectAll_User_Profile;
COMMIT;
CREATE OR REPLACE PROCEDURE SelectWhereProfile
(
    p_profile_name IN VARCHAR2,
    C_cursor OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN C_cursor FOR
    SELECT PROFILE, RESOURCE_NAME, RESOURCE_TYPE, LIMIT
    FROM DBA_PROFILES
    WHERE PROFILE = p_profile_name
    ORDER BY PROFILE, RESOURCE_NAME;
END SelectWhereProfile;

CREATE OR REPLACE PROCEDURE AlterProfileToUser (
    p_username IN VARCHAR2,
    p_new_profile IN VARCHAR2
)
IS
BEGIN
    EXECUTE IMMEDIATE 'ALTER USER ' || p_username || ' PROFILE ' || p_new_profile;
    DBMS_OUTPUT.PUT_LINE('Profile ' || p_new_profile || ' duoc cap cho ' || p_username || ' thanh cong.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('That bai vs loi: ' || SQLERRM);
END AlterProfileToUser;
CREATE OR REPLACE PROCEDURE Update_TrangThaiTruyCapDe (
    p_MaDeThi IN VARCHAR2,
    p_TrangThaiTruyCapDe IN VARCHAR2
) AS
BEGIN
    UPDATE DeThi
    SET TrangThaiTruyCapDe = p_TrangThaiTruyCapDe
    WHERE MaDeThi = p_MaDeThi;
    COMMIT;
    -- Ki?m tra s? l??ng b?n ghi ?ã ???c c?p nh?t
    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'MaDeThi không t?n t?i.');
    END IF;
END;
CREATE OR REPLACE PROCEDURE LayTongCongNo (
    p_mahs IN VARCHAR2,
    p_tongconno OUT FLOAT
) AS
    CURSOR cur_congno IS
        SELECT TONGCONGNO FROM NV001.CONGNO WHERE mahs = p_mahs;
    v_no NV001.CONGNO.TONGCONGNO%TYPE;
    v_tongconno FLOAT := 0;
BEGIN
    OPEN cur_congno;
    LOOP
        FETCH cur_congno INTO v_no;
        EXIT WHEN cur_congno%NOTFOUND;
        v_tongconno := v_tongconno + v_no;
    END LOOP;
    CLOSE cur_congno;
    
    p_tongconno := v_tongconno;
END LayTongCongNo;
/
CREATE OR REPLACE PROCEDURE UpdateTrangThaiCongNo (
    p_MaCongNo NV001.CONGNO.MACONGNO%TYPE
) IS
BEGIN
    UPDATE NV001.CONGNO
    SET TRANGTHAI = 'Da thanh toan'
    WHERE MACONGNO = p_MaCongNo;
    
    COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GetMaCongNoByMaHS (
    p_MaHS IN NV001.CONGNO.MAHS%TYPE,
    p_MaCongNo OUT NV001.CONGNO.MACONGNO%TYPE
) IS
    CURSOR congno_cursor IS
        SELECT MACONGNO
        FROM NV001.CONGNO
        WHERE MAHS = p_MaHS;

    v_MaCongNo NV001.CONGNO.MACONGNO%TYPE;
BEGIN
    OPEN congno_cursor;
    FETCH congno_cursor INTO v_MaCongNo;

    IF congno_cursor%FOUND THEN
        p_MaCongNo := v_MaCongNo;
    ELSE
        p_MaCongNo := NULL;
        DBMS_OUTPUT.PUT_LINE('No record found for the given MAHS.');
    END IF;

    CLOSE congno_cursor;
END;
/
CREATE OR REPLACE PROCEDURE GetTrangThaiByMaHS (
    p_MaHS IN NV001.CONGNO.MAHS%TYPE,
    p_TrangThai OUT NV001.CONGNO.TRANGTHAI%TYPE
) IS
    CURSOR congno_cursor IS
        SELECT TRANGTHAI
        FROM NV001.CONGNO
        WHERE MAHS = p_MaHS;

    v_TrangThai NV001.CONGNO.TRANGTHAI%TYPE;
BEGIN
    OPEN congno_cursor;
    FETCH congno_cursor INTO v_TrangThai;

    IF congno_cursor%FOUND THEN
        p_TrangThai := v_TrangThai;
    ELSE
        p_TrangThai := NULL;
        DBMS_OUTPUT.PUT_LINE('No record found for the given MAHS.');
    END IF;

    CLOSE congno_cursor;
END;
/
--Xuat du lieu
SET SERVEROUTPUT ON
VARIABLE my_cursor REFCURSOR
EXEC DeThi_Where_MaMonHoc('MH001-TOAN', :my_cursor);
PRINT my_cursor

SET SERVEROUTPUT ON
VARIABLE my_cursor REFCURSOR
EXEC ThoiGianThi_Where_MaDeThi('DETHI-0001', :my_cursor);
PRINT my_cursor

--Xem profile cua mot user 
SELECT username, created, expiry_date, account_status, profile
FROM dba_users
WHERE username = 'NV002';

--Retore database
FLASHBACK TABLE employees TO TIMESTAMP (SYSTIMESTAMP - INTERVAL '1' HOUR);
FLASHBACK TABLE employees TO BEFORE DROP;
FLASHBACK DATABASE TO TIMESTAMP (SYSTIMESTAMP - INTERVAL '1' DAY);

SELECT log_mode FROM v$database;
SELECT flashback_on FROM v$database;
ALTER DATABASE FLASHBACK ON;
ALTER DATABASE FLASHBACK OFF;
ALTER DATABASE ENABLE BLOCK CHANGE TRACKING;-- Kich hoat Block Change Tracking

SELECT tablespace_name, retention FROM dba_tablespaces WHERE contents = 'UNDO';
ALTER SYSTEM SET UNDO_RETENTION = 3600; -- thoi gian giu Undo là 1 gio (3600 giay)
ALTER TABLESPACE UNDOTBS1 RETENTION NOGUARANTEE;
ALTER TABLESPACE UNDOTBS1 RETENTION GUARANTEE;

ALTER TABLE CONGNO ENABLE ROW MOVEMENT;
ALTER TABLE CONGNO DISABLE ROW MOVEMENT;

FLASHBACK TABLE CONGNO TO TIMESTAMP (SYSTIMESTAMP - INTERVAL '1' HOUR);
FLASHBACK TABLE CONGNO TO TIMESTAMP (SYSTIMESTAMP - INTERVAL '5' MINUTE);

GRANT ALTER USER TO NV005;
ALTER USER NV005 IDENTIFIED BY NV005;



