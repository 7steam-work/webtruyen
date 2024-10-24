-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: db:3306
-- Thời gian đã tạo: Th10 24, 2024 lúc 03:00 AM
-- Phiên bản máy phục vụ: 8.0.38
-- Phiên bản PHP: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ngonlustory`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chapters`
--

CREATE TABLE `chapters` (
  `id` bigint UNSIGNED NOT NULL,
  `story_id` int DEFAULT NULL,
  `chapter_number` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `chapters`
--

INSERT INTO `chapters` (`id`, `story_id`, `chapter_number`, `title`, `content`, `created_at`) VALUES
(1, 1, 1, 'Khởi Đầu Của Cuộc Hành Trình', 'Đây là chương đầu tiên của Chuyến Phiêu Lưu Kỳ Diệu.', '2024-10-24 02:57:22'),
(2, 1, 2, 'Phép Thuật Đầu Tiên', 'Phù thủy trẻ học được phép thuật đầu tiên của mình.', '2024-10-24 02:57:22'),
(3, 2, 1, 'Nhiệm Vụ Đến Sao Hỏa', 'Đội thám hiểm chuẩn bị cho cuộc hành trình đến Sao Hỏa.', '2024-10-24 02:57:22'),
(4, 4, 1, 'Sự Thức Tỉnh Của Anh Hùng', NULL, '2024-10-24 02:57:22'),
(5, 4, 2, 'Bắt Đầu Luyện Tập', NULL, '2024-10-24 02:57:22'),
(6, 5, 1, 'Thị Trấn Bị Ám', NULL, '2024-10-24 02:57:22'),
(7, 5, 2, 'Con Ma Đầu Tiên', NULL, '2024-10-24 02:57:22');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chapter_images`
--

CREATE TABLE `chapter_images` (
  `id` bigint UNSIGNED NOT NULL,
  `chapter_id` int DEFAULT NULL,
  `image_url` varchar(255) NOT NULL,
  `page_number` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `chapter_images`
--

INSERT INTO `chapter_images` (`id`, `chapter_id`, `image_url`, `page_number`) VALUES
(1, 4, 'img/anh_hung_thuc_tinh_trang1.jpg', 1),
(2, 4, 'img/anh_hung_thuc_tinh_trang2.jpg', 2),
(3, 5, 'img/luyen_tap_bat_dau_trang1.jpg', 1),
(4, 6, 'img/thi_tran_bi_am_trang1.jpg', 1),
(5, 6, 'img/thi_tran_bi_am_trang2.jpg', 2),
(6, 7, 'img/con_ma_dau_tien_trang1.jpg', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comments`
--

CREATE TABLE `comments` (
  `id` bigint UNSIGNED NOT NULL,
  `user_id` int DEFAULT NULL,
  `chapter_id` int DEFAULT NULL,
  `content` text NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `comments`
--

INSERT INTO `comments` (`id`, `user_id`, `chapter_id`, `content`, `created_at`) VALUES
(1, 1, 1, 'Đây là một chương tuyệt vời!', '2024-10-24 02:58:32'),
(2, 1, 2, 'Mình rất thích cách miêu tả phép thuật ở đây.', '2024-10-24 02:58:32'),
(3, 2, 1, 'Chương này thật hấp dẫn!', '2024-10-24 02:58:32'),
(4, 3, 3, 'Rất phấn khích cho chuyến đi lên Sao Hỏa!', '2024-10-24 02:58:32'),
(5, 4, 5, 'Chương này làm mình thấy lạnh sống lưng.', '2024-10-24 02:58:32'),
(6, 5, 6, 'Con ma đầu tiên xuất hiện thật đáng sợ.', '2024-10-24 02:58:32');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `favorites`
--

CREATE TABLE `favorites` (
  `user_id` int NOT NULL,
  `story_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `favorites`
--

INSERT INTO `favorites` (`user_id`, `story_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 3),
(4, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `genres`
--

CREATE TABLE `genres` (
  `id` bigint UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `genres`
--

INSERT INTO `genres` (`id`, `name`) VALUES
(5, 'Hài hước'),
(4, 'Khoa học viễn tưởng'),
(6, 'Kinh dị'),
(1, 'Kỳ ảo'),
(3, 'Lãng mạn'),
(2, 'Phiêu lưu'),
(7, 'Tâm lý');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ratings`
--

CREATE TABLE `ratings` (
  `user_id` int NOT NULL,
  `story_id` int NOT NULL,
  `rating` int DEFAULT NULL
) ;

--
-- Đang đổ dữ liệu cho bảng `ratings`
--

INSERT INTO `ratings` (`user_id`, `story_id`, `rating`) VALUES
(1, 1, 5),
(1, 2, 4),
(2, 1, 4),
(3, 3, 5),
(4, 4, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `stories`
--

CREATE TABLE `stories` (
  `id` bigint UNSIGNED NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `description` text,
  `cover_image` varchar(255) DEFAULT NULL,
  `type` enum('novel','manga') NOT NULL,
  `status` enum('ongoing','completed','hiatus') NOT NULL DEFAULT 'ongoing',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `stories`
--

INSERT INTO `stories` (`id`, `title`, `author`, `description`, `cover_image`, `type`, `status`, `created_at`) VALUES
(1, 'Chuyến Phiêu Lưu Kỳ Diệu', 'Alice Johnson', 'Một cuộc phiêu lưu kỳ ảo của một phù thủy trẻ tuổi.', 'bia_chuyen_phieu_luu_ky_dieu.jpg', 'novel', 'ongoing', '2024-10-24 02:55:03'),
(2, 'Những Kẻ Cướp Ngân Hà', 'John Doe', 'Một câu chuyện khoa học viễn tưởng về những nhà thám hiểm không gian.', 'bia_nhung_ke_cuop_ngan_ha.jpg', 'novel', 'completed', '2024-10-24 02:55:03'),
(3, 'Tình Yêu Xuyên Thời Gian', 'Jane Smith', 'Một mối tình vượt qua cả thời gian.', 'bia_tinh_yeu_xuyen_thoi_gian.jpg', 'novel', 'hiatus', '2024-10-24 02:55:03'),
(4, 'Sự Thức Tỉnh Của Anh Hùng', 'Mika Tanaka', 'Một manga về một anh hùng trẻ tuổi đang luyện tập để cứu thế giới.', 'bia_su_thuc_tinh_cua_anh_hung.jpg', 'manga', 'ongoing', '2024-10-24 02:55:03'),
(5, 'Thị Trấn Ma', 'Samuel Lee', 'Một manga kinh dị về một thị trấn bị những linh hồn bí ẩn ám.', 'bia_thi_tran_ma.jpg', 'manga', 'completed', '2024-10-24 02:55:03');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `story_genres`
--

CREATE TABLE `story_genres` (
  `story_id` int NOT NULL,
  `genre_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `story_genres`
--

INSERT INTO `story_genres` (`story_id`, `genre_id`) VALUES
(1, 1),
(1, 2),
(2, 4),
(3, 3),
(4, 1),
(4, 2),
(5, 6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint UNSIGNED NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` enum('user','admin') DEFAULT 'user',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `role`, `created_at`) VALUES
(1, 'user1', 'user1', 'user1@gmail.com', 'user', '2024-10-24 02:44:09'),
(2, 'user2', 'user2', 'user2@gmail.com', 'user', '2024-10-24 02:44:09'),
(3, 'user3', 'user3', 'user3@gmail.com', 'user', '2024-10-24 02:44:09'),
(4, 'user4', 'user4', 'user4@gmail.com', 'user', '2024-10-24 02:44:09'),
(5, 'user5', 'user5', 'user5@gmail.com', 'user', '2024-10-24 02:44:09');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chapters`
--
ALTER TABLE `chapters`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Chỉ mục cho bảng `chapter_images`
--
ALTER TABLE `chapter_images`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Chỉ mục cho bảng `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Chỉ mục cho bảng `favorites`
--
ALTER TABLE `favorites`
  ADD PRIMARY KEY (`user_id`,`story_id`);

--
-- Chỉ mục cho bảng `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Chỉ mục cho bảng `ratings`
--
ALTER TABLE `ratings`
  ADD PRIMARY KEY (`user_id`,`story_id`);

--
-- Chỉ mục cho bảng `stories`
--
ALTER TABLE `stories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Chỉ mục cho bảng `story_genres`
--
ALTER TABLE `story_genres`
  ADD PRIMARY KEY (`story_id`,`genre_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chapters`
--
ALTER TABLE `chapters`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `chapter_images`
--
ALTER TABLE `chapter_images`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `comments`
--
ALTER TABLE `comments`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `genres`
--
ALTER TABLE `genres`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `stories`
--
ALTER TABLE `stories`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
