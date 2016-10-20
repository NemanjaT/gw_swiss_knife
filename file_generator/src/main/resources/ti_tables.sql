drop table if exists `TI_WVW_MATCHES`;
create table if not exists `TI_WVW_MATCHES` (
	ID int primary key auto_increment,
	`ARRAY_VAL` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_WVW_MATCH`;
create table if not exists `TI_WVW_MATCH` (
	ID int primary key auto_increment,
	`KILLS_ID` int ,
	`START_TIME` varchar(2000) default '',
	`WORLDS_ID` int ,
	`MAPS_ID` int ,
	`SCORES_ID` int ,
	`END_TIME` varchar(2000) default '',
	`SEQ_NO` varchar(2000) default '',
	`ALL_WORLDS_ID` int ,
	`DEATHS_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_WVW_OBJECTIVES`;
create table if not exists `TI_WVW_OBJECTIVES` (
	ID int primary key auto_increment,
	`ARRAY_VAL` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_WVW_OBJECTIVE`;
create table if not exists `TI_WVW_OBJECTIVE` (
	ID int primary key auto_increment,
	`MAP_TYPE` varchar(2000) default '',
	`SECTOR_ID` int ,
	`MAP_ID` int ,
	`NAME` varchar(2000) default '',
	`SEQ_NO` varchar(2000) default '',
	`TYPE` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_COLORS`;
create table if not exists `TI_COLORS` (
	ID int primary key auto_increment,
	`ARRAY_VAL` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_COLOR`;
create table if not exists `TI_COLOR` (
	ID int primary key auto_increment,
	`ITEM` int ,
	`BASE_RGB_ID` int ,
	`NAME` varchar(2000) default '',
	`METAL_ID` int ,
	`SEQ_NO` int ,
	`CATEGORIES_ID` int ,
	`LEATHER_ID` int ,
	`CLOTH_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_ITEMS`;
create table if not exists `TI_ITEMS` (
	ID int primary key auto_increment,
	`ARRAY_VAL` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_ITEM`;
create table if not exists `TI_ITEM` (
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
	`SEQ_NO` int ,
	`RARITY` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_SKINS`;
create table if not exists `TI_SKINS` (
	ID int primary key auto_increment,
	`ARRAY_VAL` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_SKIN`;
create table if not exists `TI_SKIN` (
	ID int primary key auto_increment,
	`NAME` varchar(2000) default '',
	`FLAGS_ID` int ,
	`ICON` varchar(2000) default '',
	`RESTRICTIONS_ID` int ,
	`DETAILS_ID` int ,
	`SEQ_NO` int ,
	`TYPE` varchar(2000) default '',
	`RARITY` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_KILLS`;
create table if not exists `TI_KILLS` (
	ID int primary key auto_increment,
	`RED` int ,
	`GREEN` int ,
	`BLUE` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_WORLDS`;
create table if not exists `TI_WORLDS` (
	ID int primary key auto_increment,
	`RED` int ,
	`GREEN` int ,
	`BLUE` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_MAPS`;
create table if not exists `TI_MAPS` (
	ID int primary key auto_increment,
	`MAPS_REF_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_SCORES`;
create table if not exists `TI_SCORES` (
	ID int primary key auto_increment,
	`RED` int ,
	`GREEN` int ,
	`BLUE` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_ALL_WORLDS`;
create table if not exists `TI_ALL_WORLDS` (
	ID int primary key auto_increment,
	`RED_ID` int ,
	`GREEN_ID` int ,
	`BLUE_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_DEATHS`;
create table if not exists `TI_DEATHS` (
	ID int primary key auto_increment,
	`RED` int ,
	`GREEN` int ,
	`BLUE` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_BASE_RGB`;
create table if not exists `TI_BASE_RGB` (
	ID int primary key auto_increment,
	`ARRAY_VAL` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_METAL`;
create table if not exists `TI_METAL` (
	ID int primary key auto_increment,
	`SATURATION` numeric(18,4) ,
	`BRIGHTNESS` int ,
	`CONTRAST` numeric(18,4) ,
	`LIGHTNESS` numeric(18,4) ,
	`HUE` int ,
	`RGB_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_CATEGORIES`;
create table if not exists `TI_CATEGORIES` (
	ID int primary key auto_increment,
	`ARRAY_VAL` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_LEATHER`;
create table if not exists `TI_LEATHER` (
	ID int primary key auto_increment,
	`SATURATION` numeric(18,4) ,
	`BRIGHTNESS` int ,
	`CONTRAST` numeric(18,4) ,
	`LIGHTNESS` numeric(18,4) ,
	`HUE` int ,
	`RGB_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_CLOTH`;
create table if not exists `TI_CLOTH` (
	ID int primary key auto_increment,
	`SATURATION` numeric(18,4) ,
	`BRIGHTNESS` int ,
	`CONTRAST` numeric(18,4) ,
	`LIGHTNESS` numeric(18,4) ,
	`HUE` int ,
	`RGB_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_FLAGS`;
create table if not exists `TI_FLAGS` (
	ID int primary key auto_increment,
	`ARRAY_VAL` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_RESTRICTIONS`;
create table if not exists `TI_RESTRICTIONS` (
	ID int primary key auto_increment,
	`ARRAY_VAL` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_GAME_TYPES`;
create table if not exists `TI_GAME_TYPES` (
	ID int primary key auto_increment,
	`ARRAY_VAL` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_DETAILS`;
create table if not exists `TI_DETAILS` (
	ID int primary key auto_increment,
	`INFIX_UPGRADE_ID` int ,
	`WEIGHT_CLASS` varchar(2000) default '',
	`SECONDARY_SUFFIX_ITEM_ID` varchar(2000) default '',
	`DEFENSE` int ,
	`SUFFIX_ITEM_ID` int ,
	`INFUSION_SLOTS_ID` int ,
	`TYPE` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_FLAGS`;
create table if not exists `TI_FLAGS` (
	ID int primary key auto_increment,
	`ARRAY_VAL` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_RESTRICTIONS`;
create table if not exists `TI_RESTRICTIONS` (
	ID int primary key auto_increment,
	`ARRAY_VAL` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_DETAILS`;
create table if not exists `TI_DETAILS` (
	ID int primary key auto_increment,
	`WEIGHT_CLASS` varchar(2000) default '',
	`TYPE` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_MAPS_REF`;
create table if not exists `TI_MAPS_REF` (
	ID int primary key auto_increment,
	`KILLS_ID` int ,
	`SCORES_ID` int ,
	`OBJECTIVES_ID` int ,
	`SEQ_NO` int ,
	`TYPE` varchar(2000) default '',
	`BONUSES_ID` int ,
	`DEATHS_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_RED`;
create table if not exists `TI_RED` (
	ID int primary key auto_increment,
	`ARRAY_VAL` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_GREEN`;
create table if not exists `TI_GREEN` (
	ID int primary key auto_increment,
	`ARRAY_VAL` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_BLUE`;
create table if not exists `TI_BLUE` (
	ID int primary key auto_increment,
	`ARRAY_VAL` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_RGB`;
create table if not exists `TI_RGB` (
	ID int primary key auto_increment,
	`ARRAY_VAL` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_RGB`;
create table if not exists `TI_RGB` (
	ID int primary key auto_increment,
	`ARRAY_VAL` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_RGB`;
create table if not exists `TI_RGB` (
	ID int primary key auto_increment,
	`ARRAY_VAL` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_INFIX_UPGRADE`;
create table if not exists `TI_INFIX_UPGRADE` (
	ID int primary key auto_increment,
	`ATTRIBUTES_ID` int ,
	`SEQ_NO` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_INFUSION_SLOTS`;
create table if not exists `TI_INFUSION_SLOTS` (
	ID int primary key auto_increment,
	`ARRAY_VAL` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_KILLS`;
create table if not exists `TI_KILLS` (
	ID int primary key auto_increment,
	`RED` int ,
	`GREEN` int ,
	`BLUE` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_SCORES`;
create table if not exists `TI_SCORES` (
	ID int primary key auto_increment,
	`RED` int ,
	`GREEN` int ,
	`BLUE` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_OBJECTIVES`;
create table if not exists `TI_OBJECTIVES` (
	ID int primary key auto_increment,
	`OBJECTIVES_REF_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_BONUSES`;
create table if not exists `TI_BONUSES` (
	ID int primary key auto_increment,
	`ARRAY_VAL` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_DEATHS`;
create table if not exists `TI_DEATHS` (
	ID int primary key auto_increment,
	`RED` int ,
	`GREEN` int ,
	`BLUE` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_ATTRIBUTES`;
create table if not exists `TI_ATTRIBUTES` (
	ID int primary key auto_increment,
	`ATTRIBUTES_REF_ID` int ,
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_OBJECTIVES_REF`;
create table if not exists `TI_OBJECTIVES_REF` (
	ID int primary key auto_increment,
	`OWNER` varchar(2000) default '',
	`CLAIMED_AT` varchar(2000) default '',
	`LAST_FLIPPED` varchar(2000) default '',
	`SEQ_NO` varchar(2000) default '',
	`TYPE` varchar(2000) default '',
	`CLAIMED_BY` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


drop table if exists `TI_ATTRIBUTES_REF`;
create table if not exists `TI_ATTRIBUTES_REF` (
	ID int primary key auto_increment,
	`MODIFIER` int ,
	`ATTRIBUTE` varchar(2000) default '',
	`DC` datetime ,
	`UC` varchar(60) default '',
	`DM` datetime ,
	`UM` varchar(1000) default ''
);


