CREATE DATABASE IF NOT EXISTS ngonlustory;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    role ENUM('user', 'admin') DEFAULT 'user',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE genres (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE stories (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    description TEXT,
    cover_image VARCHAR(255),
    type ENUM('novel', 'manga') NOT NULL,  -- Phân biệt giữa truyện tranh và truyện chữ
    status ENUM('ongoing', 'completed', 'hiatus') NOT NULL DEFAULT 'ongoing', 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE story_genres (
    story_id INT REFERENCES stories(id) ON DELETE CASCADE,
    genre_id INT REFERENCES genres(id) ON DELETE CASCADE,
    PRIMARY KEY (story_id, genre_id)
);


CREATE TABLE chapters (
    id SERIAL PRIMARY KEY,
    story_id INT REFERENCES stories(id) ON DELETE CASCADE,
    chapter_number INT NOT NULL,
    title VARCHAR(255),
    content TEXT, -- Chỉ dùng cho truyện chữ
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE chapter_images (
    id SERIAL PRIMARY KEY,
    chapter_id INT REFERENCES chapters(id) ON DELETE CASCADE,
    image_url VARCHAR(255) NOT NULL,
    page_number INT NOT NULL
);


CREATE TABLE favorites (
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    story_id INT REFERENCES stories(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, story_id)
);


CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    chapter_id INT REFERENCES chapters(id) ON DELETE CASCADE,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE ratings (
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    story_id INT REFERENCES stories(id) ON DELETE CASCADE,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    PRIMARY KEY (user_id, story_id)
);
