create table `WVW_MATCHES` (
	ID int primary key auto_increment,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


create table `WVW_MATCH` (
	ID int primary key auto_increment,
	`KILLS_ID` int ,
	`START_TIME` varchar(2000) default '',
	`WORLDS_ID` int ,
	`MAPS_ID` int ,
	`SCORES_ID` int ,
	`END_TIME` varchar(2000) default '',
	`ID` varchar(2000) default '',
	`ALL_WORLDS_ID` int ,
	`DEATHS_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


create table `WVW_OBJECTIVES` (
	ID int primary key auto_increment,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


create table `WVW_OBJECTIVE` (
	ID int primary key auto_increment,
	`MAP_TYPE` varchar(2000) default '',
	`SECTOR_ID` int ,
	`MAP_ID` int ,
	`NAME` varchar(2000) default '',
	`ID` varchar(2000) default '',
	`TYPE` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


create table `COLORS` (
	ID int primary key auto_increment,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


create table `COLOR` (
	ID int primary key auto_increment,
	`ITEM` int ,
	`BASE_RGB_ID` int ,
	`NAME` varchar(2000) default '',
	`METAL_ID` int ,
	`ID` int ,
	`CATEGORIES_ID` int ,
	`LEATHER_ID` int ,
	`CLOTH_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


create table `ITEMS` (
	ID int primary key auto_increment,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


create table `ITEM` (
	ID int primary key auto_increment,
	`VENDOR_VALUE` int ,
	`LEVEL` int ,
	`DEFAULT_SKIN` int ,
	`FLAGS_ID` int ,
	`ICON` varchar(2000) default '',
	`DESCRIPTION` varchar(2000) default '',
	`RESTRICTIONS_ID` int ,
	`GAME_TYPES_ID` int ,
	`TYPE` varchar(2000) default '',
	`CHAT_LINK` varchar(2000) default '',
	`NAME` varchar(2000) default '',
	`DETAILS_ID` int ,
	`ID` int ,
	`RARITY` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


create table `SKINS` (
	ID int primary key auto_increment,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


create table `SKIN` (
	ID int primary key auto_increment,
	`NAME` varchar(2000) default '',
	`FLAGS_ID` int ,
	`ICON` varchar(2000) default '',
	`RESTRICTIONS_ID` int ,
	`DETAILS_ID` int ,
	`ID` int ,
	`TYPE` varchar(2000) default '',
	`RARITY` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


