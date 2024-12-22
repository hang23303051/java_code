/*
 Navicat Premium Dump SQL

 Source Server         : hang的mysql
 Source Server Type    : MySQL
 Source Server Version : 80018 (8.0.18)
 Source Host           : localhost:3306
 Source Schema         : mario

 Target Server Type    : MySQL
 Target Server Version : 80018 (8.0.18)
 File Encoding         : 65001

 Date: 23/12/2024 00:29:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for game_records
-- ----------------------------
DROP TABLE IF EXISTS `game_records`;
CREATE TABLE `game_records`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `score` int(11) NULL DEFAULT 0,
  `blood` int(11) NULL DEFAULT 3,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `level` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game_records
-- ----------------------------
INSERT INTO `game_records` VALUES (1, '2', 0, 3, '2024-12-08 21:48:54', 1);
INSERT INTO `game_records` VALUES (2, 'hang', 47, 3, '2024-12-16 10:36:11', 5);
INSERT INTO `game_records` VALUES (3, 'hang3', 0, 3, '2024-12-15 02:17:11', 1);
INSERT INTO `game_records` VALUES (4, 'HUA', 5, 1, '2024-12-16 08:48:37', 1);
INSERT INTO `game_records` VALUES (5, 'test', 7, 3, '2024-12-16 12:29:01', 1);

-- ----------------------------
-- Table structure for game_results
-- ----------------------------
DROP TABLE IF EXISTS `game_results`;
CREATE TABLE `game_results`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `player1_score` int(11) NOT NULL,
  `player1_blood` int(11) NOT NULL,
  `player2_score` int(11) NOT NULL,
  `player2_blood` int(11) NOT NULL,
  `result` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `timestamp` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 119 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game_results
-- ----------------------------
INSERT INTO `game_results` VALUES (1, 1, 'Player1', 0, 0, 0, 3, 'Mario is dead', '2024-11-30 06:12:31');
INSERT INTO `game_results` VALUES (2, 3, 'Player1', 2, 2, 5, 1, 'Success', '2024-12-04 10:04:47');
INSERT INTO `game_results` VALUES (3, 4, 'Player1', 1, 0, 0, 3, 'Mario is dead', '2024-12-09 04:58:02');
INSERT INTO `game_results` VALUES (4, 4, 'Player1', 3, 3, 11, 3, 'Success', '2024-12-09 05:44:09');
INSERT INTO `game_results` VALUES (5, 5, 'Player1', 1, 3, 14, 3, 'Success', '2024-12-09 05:48:48');
INSERT INTO `game_results` VALUES (6, 6, 'Player1', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-12 17:19:53');
INSERT INTO `game_results` VALUES (7, 6, 'Player1', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-12 17:20:03');
INSERT INTO `game_results` VALUES (8, 6, 'Player1', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-12 17:20:10');
INSERT INTO `game_results` VALUES (9, 6, 'Player1', 0, 0, 0, 3, 'Mario1 is dead', '2024-12-12 17:20:17');
INSERT INTO `game_results` VALUES (10, 6, 'Player1', 0, 0, 0, 3, 'Mario1 is dead', '2024-12-12 17:20:25');
INSERT INTO `game_results` VALUES (11, 6, 'Player1', 0, 0, 0, 3, 'Mario1 is dead', '2024-12-12 17:20:31');
INSERT INTO `game_results` VALUES (12, 6, 'Player1', 0, 0, 0, 3, 'Mario1 is dead', '2024-12-12 17:20:37');
INSERT INTO `game_results` VALUES (13, 6, 'Player1', 7, 0, 5, 3, 'Mario1 is dead', '2024-12-12 17:21:22');
INSERT INTO `game_results` VALUES (14, 6, 'Player1', 0, 0, 0, 3, 'Mario1 is dead', '2024-12-12 17:21:30');
INSERT INTO `game_results` VALUES (15, 6, 'Player1', 5, 0, 5, 3, 'Mario1 is dead', '2024-12-12 17:21:51');
INSERT INTO `game_results` VALUES (16, 6, 'Player1', 19, 3, 17, 0, 'Mario2 is dead', '2024-12-12 17:23:47');
INSERT INTO `game_results` VALUES (17, 6, 'Player1', 5, 3, 5, 0, 'Mario2 is dead', '2024-12-12 17:24:09');
INSERT INTO `game_results` VALUES (18, 6, 'Player1', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-12 17:24:15');
INSERT INTO `game_results` VALUES (19, 6, 'Player1', 15, 3, 18, 0, 'Mario2 is dead', '2024-12-12 17:26:00');
INSERT INTO `game_results` VALUES (20, 6, 'Player1', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-12 17:26:13');
INSERT INTO `game_results` VALUES (21, 6, 'Player1', 28, 1, 30, 3, 'Success', '2024-12-12 17:27:51');
INSERT INTO `game_results` VALUES (22, 6, 'Player1', 10, 3, 11, 0, 'Mario2 is dead', '2024-12-12 17:47:48');
INSERT INTO `game_results` VALUES (23, 6, 'Player1', 11, 3, 11, 0, 'Mario2 is dead', '2024-12-12 20:14:14');
INSERT INTO `game_results` VALUES (24, 6, 'Player1', 15, 3, 34, 3, 'Success', '2024-12-12 20:15:33');
INSERT INTO `game_results` VALUES (25, 6, 'Player1', 10, 0, 11, 3, 'Mario1 is dead', '2024-12-14 00:02:43');
INSERT INTO `game_results` VALUES (26, 6, 'Player1', 15, 3, 38, 1, 'Success', '2024-12-14 00:04:21');
INSERT INTO `game_results` VALUES (27, 6, 'Player1', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-14 09:36:42');
INSERT INTO `game_results` VALUES (28, 6, 'Player1', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-14 09:36:53');
INSERT INTO `game_results` VALUES (29, 6, 'Player1', 27, 2, 38, 2, 'Success', '2024-12-14 09:38:35');
INSERT INTO `game_results` VALUES (30, 6, 'Player1', 11, 1, 11, 0, 'Mario2 is dead', '2024-12-14 10:13:06');
INSERT INTO `game_results` VALUES (31, 6, 'Player1', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-14 10:13:25');
INSERT INTO `game_results` VALUES (32, 6, 'Player1', 10, 2, 12, 0, 'Mario2 is dead', '2024-12-14 10:53:27');
INSERT INTO `game_results` VALUES (33, 6, 'Player1', 11, 3, 11, -1, 'Mario2 is dead', '2024-12-14 11:01:04');
INSERT INTO `game_results` VALUES (34, 6, 'Player1', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-14 11:01:15');
INSERT INTO `game_results` VALUES (35, 6, 'Player1', 0, 0, 0, -24, 'Mario1 is dead', '2024-12-14 11:01:15');
INSERT INTO `game_results` VALUES (36, 6, 'Player1', 10, 3, 13, 0, 'Mario2 is dead', '2024-12-14 13:16:33');
INSERT INTO `game_results` VALUES (37, 6, 'Player1', 11, 3, 12, 0, 'Mario2 is dead', '2024-12-14 13:17:06');
INSERT INTO `game_results` VALUES (38, 6, 'Player1', 19, 3, 17, 0, 'Mario2 is dead', '2024-12-14 13:17:45');
INSERT INTO `game_results` VALUES (39, 6, 'Player1', 4, 3, 19, 0, 'Mario2 is dead', '2024-12-14 14:01:53');
INSERT INTO `game_results` VALUES (40, 6, 'Player1', 3, 0, 10, 3, 'Mario1 is dead', '2024-12-14 14:18:05');
INSERT INTO `game_results` VALUES (41, 6, 'Player1', 22, 1, 21, 3, 'Success', '2024-12-14 14:29:41');
INSERT INTO `game_results` VALUES (42, 6, 'Player1', 7, 0, 10, 3, 'Mario1 is dead', '2024-12-14 15:00:49');
INSERT INTO `game_results` VALUES (43, 6, 'Player1', 6, 1, 10, 0, 'Mario2 is dead', '2024-12-14 17:52:32');
INSERT INTO `game_results` VALUES (44, 6, 'Player1', 2, 3, 5, 0, 'Mario2 is dead', '2024-12-14 17:52:48');
INSERT INTO `game_results` VALUES (45, 6, 'Player1', 3, 0, 10, 3, 'Mario1 is dead', '2024-12-14 19:57:53');
INSERT INTO `game_results` VALUES (46, 6, 'Player1', 6, 0, 10, 3, 'Mario1 is dead', '2024-12-14 20:02:13');
INSERT INTO `game_results` VALUES (47, 6, 'Player1', 6, 0, 10, 3, 'Mario1 is dead', '2024-12-14 20:06:27');
INSERT INTO `game_results` VALUES (48, 6, 'Player1', 6, 1, 10, 0, 'Mario2 is dead', '2024-12-14 20:23:01');
INSERT INTO `game_results` VALUES (49, 6, 'Player1', 7, 0, 10, 1, 'Mario1 is dead', '2024-12-14 20:24:44');
INSERT INTO `game_results` VALUES (50, 6, 'Player1', 2, 0, 5, 3, 'Mario1 is dead', '2024-12-14 20:26:51');
INSERT INTO `game_results` VALUES (51, 6, 'Player1', 1, 0, 5, 2, 'Mario1 is dead', '2024-12-14 21:22:03');
INSERT INTO `game_results` VALUES (52, 6, 'Player1', 29, 3, 15, 3, 'Success', '2024-12-14 21:24:05');
INSERT INTO `game_results` VALUES (53, 7, 'Player1', 12, 3, 10, 3, 'Success', '2024-12-14 21:33:24');
INSERT INTO `game_results` VALUES (54, 6, 'Player1', 7, 2, 10, 0, 'Mario2 is dead', '2024-12-14 22:39:59');
INSERT INTO `game_results` VALUES (55, 6, 'Player1', 2, 0, 10, 3, 'Mario1 is dead', '2024-12-14 22:40:23');
INSERT INTO `game_results` VALUES (56, 6, 'Player1', 2, 3, 10, 0, 'Mario2 is dead', '2024-12-14 22:40:44');
INSERT INTO `game_results` VALUES (57, 6, 'Player1', 21, 2, 15, 3, 'Success', '2024-12-14 22:41:51');
INSERT INTO `game_results` VALUES (58, 6, 'Player1', 6, 0, 10, 3, 'Mario1 is dead', '2024-12-14 23:29:27');
INSERT INTO `game_results` VALUES (59, 6, 'Player1', 1, 0, 5, 3, 'Mario1 is dead', '2024-12-14 23:31:43');
INSERT INTO `game_results` VALUES (60, 6, 'hang', 1, 0, 5, 3, 'Mario1 is dead', '2024-12-14 16:39:15');
INSERT INTO `game_results` VALUES (61, 6, 'hang', 11, 3, 15, 3, 'Success', '2024-12-14 16:42:43');
INSERT INTO `game_results` VALUES (62, 7, 'hang2', 1, 2, 5, 0, 'Mario2 is dead', '2024-12-14 16:53:42');
INSERT INTO `game_results` VALUES (63, 7, 'hang2', 2, 0, 15, 3, 'Mario1 is dead', '2024-12-14 17:01:22');
INSERT INTO `game_results` VALUES (64, 7, 'hang2', 1, 3, 5, 0, 'Mario2 is dead', '2024-12-14 17:04:01');
INSERT INTO `game_results` VALUES (65, 8, 'hang3', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-15 02:17:11');
INSERT INTO `game_results` VALUES (66, 6, 'hang', 17, 0, 17, 2, 'Mario1 is dead', '2024-12-15 02:52:46');
INSERT INTO `game_results` VALUES (67, 6, 'hang', 17, 0, 16, 2, 'Mario1 is dead', '2024-12-15 02:59:43');
INSERT INTO `game_results` VALUES (68, 6, 'hang', 6, 3, 5, 0, 'Mario2 is dead', '2024-12-15 03:01:29');
INSERT INTO `game_results` VALUES (69, 6, 'hang', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-15 03:03:30');
INSERT INTO `game_results` VALUES (70, 6, 'hang', 5, 3, 5, 0, 'Mario2 is dead', '2024-12-15 03:04:53');
INSERT INTO `game_results` VALUES (71, 6, 'hang', 6, 0, 7, 3, 'Mario1 is dead', '2024-12-15 03:24:21');
INSERT INTO `game_results` VALUES (72, 6, 'hang', 6, 3, 13, 0, 'Mario2 is dead', '2024-12-15 03:25:33');
INSERT INTO `game_results` VALUES (73, 6, 'hang', 12, 0, 7, 2, 'Mario1 is dead', '2024-12-15 03:26:44');
INSERT INTO `game_results` VALUES (74, 6, 'hang', 13, 0, 7, 3, 'Mario1 is dead', '2024-12-15 03:35:21');
INSERT INTO `game_results` VALUES (75, 6, 'hang', 0, 3, 5, 0, 'Mario2 is dead', '2024-12-15 03:36:36');
INSERT INTO `game_results` VALUES (76, 6, 'hang', 0, 3, 0, 0, 'Mario2 is dead', '2024-12-15 03:44:25');
INSERT INTO `game_results` VALUES (77, 6, 'hang', 10, 0, 0, 3, 'Mario1 is dead', '2024-12-15 03:45:30');
INSERT INTO `game_results` VALUES (78, 6, 'hang', 1, 0, 6, 3, 'Mario1 is dead', '2024-12-15 03:50:31');
INSERT INTO `game_results` VALUES (79, 6, 'hang', 6, 0, 6, 2, 'Mario1 is dead', '2024-12-15 03:50:50');
INSERT INTO `game_results` VALUES (80, 6, 'hang', 2, 3, 11, 0, 'Mario2 is dead', '2024-12-15 03:51:25');
INSERT INTO `game_results` VALUES (81, 6, 'hang', 15, 0, 5, 3, 'Mario1 is dead', '2024-12-15 04:13:29');
INSERT INTO `game_results` VALUES (82, 6, 'hang', 8, 0, 17, 3, 'Mario1 is dead', '2024-12-15 07:26:37');
INSERT INTO `game_results` VALUES (83, 6, 'hang', 1, 0, 0, 3, 'Mario1 is dead', '2024-12-15 07:29:47');
INSERT INTO `game_results` VALUES (84, 6, 'hang', 1, 0, 6, 1, 'Mario1 is dead', '2024-12-15 09:05:53');
INSERT INTO `game_results` VALUES (85, 6, 'hang', 5, 1, 25, 2, 'Success', '2024-12-15 09:07:10');
INSERT INTO `game_results` VALUES (86, 9, 'HUA', 12, 3, 0, 0, 'Mario2 is dead', '2024-12-16 08:32:00');
INSERT INTO `game_results` VALUES (87, 9, 'HUA', 10, 3, 0, 0, 'Mario2 is dead', '2024-12-16 08:32:38');
INSERT INTO `game_results` VALUES (88, 9, 'HUA', 10, 0, 0, 1, 'Mario1 is dead', '2024-12-16 08:33:20');
INSERT INTO `game_results` VALUES (89, 6, 'hang', 15, 0, 3, 3, 'Mario1 is dead', '2024-12-16 08:37:16');
INSERT INTO `game_results` VALUES (90, 6, 'hang', 0, 0, 5, 3, 'Mario1 is dead', '2024-12-16 08:39:10');
INSERT INTO `game_results` VALUES (91, 6, 'hang', 0, 3, 6, 0, 'Mario2 is dead', '2024-12-16 08:39:33');
INSERT INTO `game_results` VALUES (92, 6, 'hang', 2, 3, 5, 0, 'Mario2 is dead', '2024-12-16 08:39:50');
INSERT INTO `game_results` VALUES (93, 6, 'hang', 14, 0, 7, 3, 'Mario1 is dead', '2024-12-16 08:44:06');
INSERT INTO `game_results` VALUES (94, 6, 'hang', 10, 2, 23, 3, 'Success', '2024-12-16 08:45:41');
INSERT INTO `game_results` VALUES (95, 9, 'HUA', 0, 1, 5, 0, 'Mario2 is dead', '2024-12-16 08:48:37');
INSERT INTO `game_results` VALUES (96, 6, 'hang', 10, 2, 5, 0, 'Mario2 is dead', '2024-12-16 08:57:05');
INSERT INTO `game_results` VALUES (97, 6, 'hang', 5, 0, 5, 3, 'Mario1 is dead', '2024-12-16 08:57:27');
INSERT INTO `game_results` VALUES (98, 6, 'hang', 6, 3, 0, 0, 'Mario2 is dead', '2024-12-16 08:57:37');
INSERT INTO `game_results` VALUES (99, 6, 'hang', 12, 3, 20, 3, 'Success', '2024-12-16 08:58:53');
INSERT INTO `game_results` VALUES (100, 6, 'hang', 0, 0, 7, 3, 'Mario1 is dead', '2024-12-16 09:02:45');
INSERT INTO `game_results` VALUES (101, 6, 'hang', 0, 3, 7, 0, 'Mario2 is dead', '2024-12-16 09:03:14');
INSERT INTO `game_results` VALUES (102, 6, 'hang', 0, 0, 7, 3, 'Mario1 is dead', '2024-12-16 09:03:27');
INSERT INTO `game_results` VALUES (103, 6, 'hang', 5, 0, 7, 3, 'Mario1 is dead', '2024-12-16 09:03:55');
INSERT INTO `game_results` VALUES (104, 6, 'hang', 28, 1, 13, 3, 'Success', '2024-12-16 09:05:27');
INSERT INTO `game_results` VALUES (105, 6, 'hang', 28, 3, 19, 3, 'Success', '2024-12-16 10:36:11');
INSERT INTO `game_results` VALUES (106, 6, 'hang', 10, 1, 16, 0, 'Mario2 is dead', '2024-12-16 10:44:33');
INSERT INTO `game_results` VALUES (107, 6, 'hang', 3, 3, 5, 0, 'Mario2 is dead', '2024-12-16 11:02:48');
INSERT INTO `game_results` VALUES (108, 6, 'hang', 5, 3, 7, 0, 'Mario2 is dead', '2024-12-16 11:05:17');
INSERT INTO `game_results` VALUES (109, 6, 'hang', 0, 2, 5, 0, 'Mario2 is dead', '2024-12-16 11:06:20');
INSERT INTO `game_results` VALUES (110, 6, 'hang', 0, 3, 5, 0, 'Mario2 is dead', '2024-12-16 11:07:49');
INSERT INTO `game_results` VALUES (111, 6, 'hang', 20, 3, 10, 3, 'Success', '2024-12-16 11:08:49');
INSERT INTO `game_results` VALUES (112, 6, 'hang', 0, 0, 5, 2, 'Mario1 is dead', '2024-12-16 11:09:37');
INSERT INTO `game_results` VALUES (113, 6, 'hang', 6, 0, 13, 3, 'Mario1 is dead', '2024-12-16 12:04:01');
INSERT INTO `game_results` VALUES (114, 6, 'hang', 7, 3, 6, 0, 'Mario2 is dead', '2024-12-16 12:04:43');
INSERT INTO `game_results` VALUES (115, 6, 'hang', 1, 2, 22, 3, 'Success', '2024-12-16 12:05:28');
INSERT INTO `game_results` VALUES (116, 10, 'test', 2, 0, 5, 3, 'Mario1 is dead', '2024-12-16 12:29:01');
INSERT INTO `game_results` VALUES (117, 10, 'test', 15, 3, 20, 3, 'Success', '2024-12-16 12:30:06');
INSERT INTO `game_results` VALUES (118, 11, 'tang', 12, 3, 0, 0, 'Mario2 is dead', '2024-12-18 15:43:57');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'zhangsan', 'V+hrLaAjA+Blsg1CoPq42WSfPZyqRWgsXZGC12g3dXs=', '2024-11-30 04:53:53', 'P8W9rFj6i19tV8pDhSASPw==');
INSERT INTO `users` VALUES (2, 'lisi', 'fYa03ObumsxUGCLohSXgyenSSDUSlFa94BnWaA5CC4k=', '2024-11-30 05:37:13', 'TKB8Z3E98JyKYgr3AqwO4A==');
INSERT INTO `users` VALUES (3, '11', 'NB2HjdX0FzMIv6gk3mali6WImYlo6yq0ZEzkqoaKenQ=', '2024-12-04 10:01:18', '3zttD153mjET2s2id/PKVw==');
INSERT INTO `users` VALUES (4, '1', 'ILtc4IkkxV7Ar8xoi2TuQz08uat6rMIod0KrMVw9l20=', '2024-12-09 04:52:19', 'm1lP6kRvvtwBZ8Q0cyBseA==');
INSERT INTO `users` VALUES (5, '2', 'FHrAPRfVJRGHjUR6mI7nRN6BrV90pKC1eVQWrlcsy1o=', '2024-12-09 05:46:18', 'TxwZCtjcincHn4yMlLlkhA==');
INSERT INTO `users` VALUES (6, 'hang', 'Q0wazKdn8O1CheGNvi7kn2my2ZALlC+v6811IEsXpLs=', '2024-12-12 17:19:35', '5YS4fh/rCjllR8LVxLVSpw==');
INSERT INTO `users` VALUES (7, 'hang2', '0x6R+kgAvTHUxYsU0QLnlxU+8W+L6Ml2IOgjtvvGqhM=', '2024-12-14 21:32:15', '/+EHzB2B90tWnUWgphmP1g==');
INSERT INTO `users` VALUES (8, 'hang3', 'CDI8ITmMTxvBwrBug6pJsrlqbOQDgPoF5PD81pBd0LA=', '2024-12-14 22:58:44', 'gGtxT9dfobZqQ6nV4dKQVw==');
INSERT INTO `users` VALUES (9, 'HUA', 'SNgR9rARjvIIOrrzCZX5cHQjBU80rvmX9zv5KtN9jIw=', '2024-12-16 16:31:21', 'q1gnYcgdZ6QBaMdyC9VNiw==');
INSERT INTO `users` VALUES (10, 'test', 'Vp3l04/wDp5JwsG/q4UvKvqhZcxdpMTH1OygVx+ry3Q=', '2024-12-16 20:28:16', 'W3r2lvx2qtcoM0XedeJ2jQ==');
INSERT INTO `users` VALUES (11, 'tang', 'nswNeIymNP3DjPCs+WddNEjxREt5oYh0VkDGJUOAyhQ=', '2024-12-18 23:43:18', 'I/gB0NrFEG3fvUxb7fQgUQ==');

SET FOREIGN_KEY_CHECKS = 1;
