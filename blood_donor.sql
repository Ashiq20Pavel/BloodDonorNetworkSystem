--
-- Database: `blood_donor`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ad_Name` varchar(10) NOT NULL,
  `ad_Pass` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ad_Name`, `ad_Pass`) VALUES
('admin', 'bdns');

-- --------------------------------------------------------

--
-- Table structure for table `blood2`
--

CREATE TABLE `blood2` (
  `First_Name` varchar(10) DEFAULT NULL,
  `Last_Name` varchar(10) NOT NULL,
  `User_Name` varchar(15) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `Confirm_Password` varchar(10) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `Contact_No` varchar(15) NOT NULL,
  `B_Group` varchar(10) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `Address` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blood2`
--

INSERT INTO `blood2` (`First_Name`, `Last_Name`, `User_Name`, `Password`, `Confirm_Password`, `Email`, `Contact_No`, `B_Group`, `Gender`, `Address`) VALUES
('Shams', 'Bin Shorab', 'anik', '12345', '12345', 'nishan@gmail.com', '019XXXXXXX', 'B+', 'Male', 'Sylhet'),
('Farha ', 'Karim', 'arin', 'aarshiya', 'aarshiya', 'arin@yahoo.com', '018XXXXXXXX', 'B+', 'Male', 'Dhaka'),
('Ashiqur', 'Rahman', 'ashiq20', 'pias', 'pias', 'ashiq.pavel@gmail.com', '01855956768', 'B+', 'Male', 'Dhaka'),
('Noyon', 'Badhon', 'noyon892', 'B.h.p.892', 'B.h.p.892', 'noyon892@gmail.com', '01733844422', 'A+', 'Male', 'Dhaka'),
('Ehatesham', 'Ul Islam', 'shondhee', '5678', '5678', 'shondhee@gmail.com', '01676260539', 'B+', 'Male', 'Dhaka'),
('Ibtida', 'Muhtasim', 'souvik', '1234', '1234', 'mk.souvik@gmail.com', '01943789199', 'O+', 'Male', 'Dhaka');

-- --------------------------------------------------------

--
-- Table structure for table `blood3`
--

CREATE TABLE `blood3` (
  `User_Name` varchar(15) NOT NULL,
  `Area` varchar(15) NOT NULL,
  `Text_Box` varchar(100) NOT NULL,
  `B_Group` varchar(10) NOT NULL,
  `Emergency` varchar(10) NOT NULL,
  `PostT&D` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blood3`
--

INSERT INTO `blood3` (`User_Name`, `Area`, `Text_Box`, `B_Group`, `Emergency`, `PostT&D`) VALUES
('anik', 'null', 'null', 'null', 'null', 'null'),
('arin', 'Dhaka', '018XXXXXXX', 'B+', 'No', '2016-12-27 10:57:14.0'),
('ashiq20', 'Dhaka', '01855956768', 'B+', 'Yes', '2016-12-27 10:54:12.0'),
('noyon892', 'Dhaka', '01733844422', '---', 'Yes', '2016-12-27 13:04:27.0'),
('shondhee', 'Dhaka', '01676260539', 'B+', 'Yes', '2016-12-27 07:57:13.0'),
('souvik', 'null', 'null', 'null', 'null', 'null');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blood2`
--
ALTER TABLE `blood2`
  ADD PRIMARY KEY (`User_Name`,`Password`,`Confirm_Password`),
  ADD UNIQUE KEY `UNIQUE` (`User_Name`);

--
-- Indexes for table `blood3`
--
ALTER TABLE `blood3`
  ADD UNIQUE KEY `UNIQUE` (`User_Name`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
