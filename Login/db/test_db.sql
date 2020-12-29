

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";



CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `users` (`id`, `user_name`, `password`, `name` , `email`) VALUES
(1, 'bob99', '123', 'burhan' , 'burrhann@gmail.com'),
(2, 'muaz', 'abc', 'muazam' , 'muazam99@gmail.com' ),
(2 , 'siv' , '12345' , 'aidiel' , 'aidiel__@gmail.com');


COMMIT;
