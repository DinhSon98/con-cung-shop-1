CREATE DATABASE con_cung_shop;
USE con_cung_shop;

INSERT INTO roles(name, description)
VALUES ('ROLE_MANAGER', 'Quản lý'),
       ('ROLE_SALE', 'Nhân viên kinh doanh'),
       ('ROLE_HR', 'Nhân viên nhân sự'),
       ('ROLE_WAREHOUSE', 'Nhân viên thủ kho');


INSERT INTO users(activated, address, avatar, email, fullname, password, phone, username, role_id)
VALUES (true, 'sai gon', 'logo-admin.png', 'admin@gmail.com', 'ADMIN', '$2a$10$mI9cSwiHFXTnYqFpC8xgrOP8VTIela7tAUzvblDUVW1/oNYqT.0wO', '0123456789', 'admin', 1);

INSERT INTO users(activated, address, avatar, email, fullname, password, phone, username, role_id)
VALUES (false, 'sai gon', 'logo-admin.png', 'admin@gmail.com', 'user1', '$2a$10$mI9cSwiHFXTnYqFpC8xgrOP8VTIela7tAUzvblDUVW1/oNYqT.0wO', '0123456789', 'user1', 2);

INSERT INTO users(activated, address, avatar, email, fullname, password, phone, username, role_id)
VALUES (true, 'sai gon', 'logo-admin.png', 'admin@gmail.com', 'user2', '$2a$10$mI9cSwiHFXTnYqFpC8xgrOP8VTIela7tAUzvblDUVW1/oNYqT.0wO', '0123456789', 'user2', 3);

INSERT INTO users(activated, address, avatar, email, fullname, password, phone, username, role_id)
VALUES (false, 'sai gon', 'logo-admin.png', 'admin@gmail.com', 'user3', '$2a$10$mI9cSwiHFXTnYqFpC8xgrOP8VTIela7tAUzvblDUVW1/oNYqT.0wO', '0123456789', 'user3', 4);



INSERT INTO categories(activated, name)
VALUES (true, 'Sữa'),
       (true, 'Tã'),
       (true, 'Quần áo'),
       (true, 'Đồ chơi');


INSERT INTO products(activated, avatar, description, name, price, quantity, category_id)
VALUES (true, 'Aptamil_0_12.jpg', 'Sữa Aptamil cho trẻ từ 0 đến 12 tháng', 'Aptamil_0_12', 150000, 10, 1),
       (true, 'Aptamil_12_24.jpg', 'Sữa Aptamil cho trẻ từ 12 đến 24 tháng', 'Aptamil_12_24', 160000, 20, 1),
       (true, 'Bubs_0_6.png', 'Sữa Bubs cho trẻ từ 0 đến 6 tháng', 'Bubs_0_6', 250000, 10, 1),
       (true, 'Bubs_6_12.png', 'Sữa Bubs cho trẻ từ 6 đến 12 tháng', 'Bubs_6_12', 280000, 12, 1),
       (true, 'Colomi.jpg', 'Sữa Colomi cho trẻ từ 6 đến 12 tháng', 'Colomi', 280000, 12, 1),
       (true, 'Enfagrow_1_3.png', 'Sữa Enfagrow cho trẻ từ 1 đến 3 tuổi', 'Enfagrow_1_3', 300000, 17, 1),
       (true, 'Enfagrow_1_6.png', 'Sữa Enfagrow cho trẻ từ 0 đến 6 tháng', 'Enfagrow_1_6', 310000, 12, 1),
       (true, 'Frisolac_0_6.jpg', 'Sữa Frisolac cho trẻ từ 0 đến 6 tháng', 'Frisolac_0_6', 210000, 12, 1),
       (true, 'Frisolac_1_3.jpg', 'Sữa Enfagrow cho trẻ từ 0 đến 6 tháng', 'Frisolac_1_3', 220000, 14, 1),
       (true, 'Meiji_0_12.jpg', ' Sữa Meiji cho trẻ từ 0 đến 12 tháng tuổi ', 'Meiji_0_12', 310000, 12, 1),
       (true, 'Meiji_12_36.jpg', 'Sữa Meiji cho trẻ từ 12 đến 36 tháng tuổi', 'Meiji_12_36', 310000, 12, 1),
       (true, 'Nan_0_6.png', 'Sữa Nan cho trẻ từ 0 đến 6 tháng tuổi', 'Nan_0_6', 120000, 24, 1),
       (true, 'Nan_1_2.png', 'Sữa Nan cho trẻ từ 1 đến 2 tuổi', 'Nan_1_2', 130000, 12, 1),
       (true, 'PediaSure_1_10.png', 'Sữa PediaSure cho trẻ từ 1 đến 10 tuổi', 'PediaSure_1_10', 800000, 24, 1),
       (true, 'Similac_2_6.png', 'Sữa Similac cho trẻ từ 2 đến 6 tháng tuổi', 'Similac_2_6', 120000, 15, 1),
       (true, 'Similac_3.png', 'Sữa Similac cho trẻ 3 tuổi', 'Similac_3', 120000, 24, 1),
       (true, 'Similac_4.png', 'Sữa Similac cho trẻ 4 tuổi', 'Similac_4', 150000, 22, 1);


INSERT INTO products(activated, avatar, description, name, price, quantity, category_id)
VALUES (true, 'Bobby_1.png', 'Tả Bobby cho trẻ dưới 12 tháng tuổi', 'Bobby_1', 340000, 22, 2),
       (true, 'Bobby_2.png', 'Tả Bobby cho trẻ dưới 24 tháng tuổi', 'Bobby_2', 350000, 20, 2),
       (true, 'Genki_1.png', 'Tả Genki cho trẻ dưới 12 tháng tuổi', 'Genki_1', 280000, 16, 2),
       (true, 'Genki_2.png', 'Tả Genki cho trẻ dưới 24 tháng tuổi', 'Genki_2', 290000, 18, 2),
       (true, 'Huggies_1.jpg', 'Tả Huggies cho trẻ dưới 12 tháng tuổi', 'Huggies_1', 340000, 22, 2),
       (true, 'Huggies_2.jpg', 'Tả Huggies cho trẻ dưới 24 tháng tuổi', 'Huggies_2', 300000, 22, 2),
       (true, 'Molfix_1.jpg', 'Tả Molfix cho trẻ dưới 12 tháng tuổi', 'Molfix_1', 320000, 12, 2),
       (true, 'Molfix_2.jpg', 'Tả Molfix cho trẻ dưới 24 tháng tuổi', 'Molfix_2', 310000, 10, 2),
       (true, 'Moony_1.jpg', 'Tả Moony cho trẻ dưới 12 tháng tuổi', 'Moony_1', 210000, 8, 2),
       (true, 'Moony_2.jpg', 'Tả Moony cho trẻ dưới 24 tháng tuổi', 'Moony_2', 200000, 14, 2),
       (true, 'Takato_1.png', 'Tả Takato cho trẻ dưới 12 tháng tuổi', 'Takato_1', 210000, 22, 2),
       (true, 'Takoto_2.png', 'Tả Takato cho trẻ dưới 24 tháng tuổi', 'Takato_2', 240000, 12, 2),
       (true, 'Pampers_1.jpg', 'Tả Pampers cho trẻ dưới 12 tháng tuổi', 'Pampers_1', 280000, 12, 2),
       (true, 'Pampers_2.jpg', 'Tả Pampers cho trẻ dưới 24 tháng tuổi', 'Pampers_2', 290000, 6, 2),
       (true, 'Whito_1.jpg', 'Tả Whito cho trẻ dưới 12 tháng tuổi', 'Whito_1', 340000, 22, 2),
       (true, 'Whito_2.jpg', 'Tả Whito cho trẻ dưới 24 tháng tuổi', 'Whito_2', 350000, 12, 2);


INSERT INTO products(activated, avatar, description, name, price, quantity, category_id)
VALUES (true, 'Bao_tay_1.jpg', 'Bao tay ông mặt trời', 'Bao_tay_1', 35000, 12, 3),
       (true, 'Bao_tay_2.jpg', 'Bao tay khủng long', 'Bao_tay_2', 36000, 10, 3),
       (true, 'Bao_tay_3.jpg', 'Bao tay thỏ con', 'Bao_tay_3', 20000, 8, 3),
       (true, 'Bo_so_sinh_1.jpg', 'Đồ bộ cho trẻ sơ sinh hoa vàng', 'Bộ đồ sơ sinh 1', 12000, 12, 3),
       (true, 'Bo_so_sinh_2.jpg', 'Đồ bộ cho trẻ sơ sinh hồng, tay dài', 'Bộ đồ sơ sinh 2', 12800, 10, 3),
       (true, 'Bo_so_sinh_3.jpg ', 'Đồ bộ cho trẻ sơ sinh vàng, quần ngắn', 'Bộ đồ sơ sinh 3', 90000, 12, 3),
       (true, 'Bo_so_sinh_4.jpg ', 'Đồ bộ cho trẻ sơ sinh vàng, quần dài', 'Bộ đồ sơ sinh 4', 100000, 12, 3),
       (true, 'Bo_so_sinh_5.jpg ', ' Đồ bộ cho trẻ sơ hồng baby', ' Bộ đồ sơ sinh 5', 12000, 12, 3),
       (true, 'Giay_1.jpg', 'Giày nữ tím', 'Giày tím', 35000, 12, 3),
       (true, 'Giay_2.jpg', 'Giày nam xanh', 'Giày xanh', 40000, 8, 3),
       (true, 'Giay_3.jpg', 'Giày nơ tím', 'Giày nơ', 42000, 12, 3),
       (true, 'Giay_4.jpg', 'Giày nữ ong vàng', 'Giày ong vàng', 35000, 12, 3),
       (true, 'Non_1.png', 'Nón ngôi sao hồng', 'Nón sao hồng', 80000, 10, 3),
       (true, 'Non_2.jpg', 'Nón hổ con', 'Nón hổ con', 82000, 12, 3),
       (true, 'Non_3.jpg', 'Nón chó con hồng', 'Nón chó con', 90000, 12, 3),
       (true, 'Non_4.jpg', 'Nón caro hồng', 'Nón caro', 90000, 12, 3),
       (true, 'Quan_1.jpg', 'Quần sơ sinh', 'Quần xanh 1', 80000, 8, 3),
       (true, 'Quan_2.jpg', 'Quần liền áo', 'Quần liền áo vàng', 82000, 12, 3);


INSERT INTO products(activated, avatar, description, name, price, quantity, category_id)
VALUES (true, 'Bac_si.jpg', 'Đồ chơi tập làm bác sĩ cho trẻ từ 3 đến 6 tuổi', 'Đồ chơi bác sĩ', 100000, 4, 4),
       (true, 'Bup_be.jpg', 'Đồ chơi búp bê cho bé gái', 'Búp bê', 82000, 8, 4),
       (true, 'Dau_bep.jpg', 'Đồ chơi đầu bếp cho bé từ 3 đến 6 tuổi', ' Đồ chơi đầu bếp', 120000, 8, 4),
       (true, 'Khung_long.jpg', 'Thú bông khủng long', 'Đồ chơi khủng long', 144000, 5, 4),
       (true, 'Ngam_nuu.jpg', 'Ngậm nứu bắp cho trẻ dưới 1 tuổi', 'Ngậm nứu', 90000, 12, 4),
       (true, 'Rap_hinh.jpg', 'Ráp hình cho bé nam', 'Ráp hình logo', 180000, 10, 4),
       (true, 'Voi.jpg', 'Gấu bông voi con', 'Voi con xám', 44000, 2, 4),
       (true, 'Xe_bo_sua.jpg', 'Xe bò sữa gỗ nhỏ cho trẻ dưới 3 tuổi', 'Xe bò sữa', 82000, 6, 4),
       (true, 'Xe_cua_nho.jpg', 'Xe cua nhỏ cho trẻ dưới 3 tuổi', 'Xe cua gỗ', 91000, 8, 4),
       (true, 'Xuc_xac.jpg', 'Xúc xắc xinh cho bé', 'Xúc xắc', 50000, 24, 4);
