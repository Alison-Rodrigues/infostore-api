CREATE ROLE infostore_carbon WITH ENCRYPTED PASSWORD '{USER PASSWORD}';

CREATE DATABASE infostore_platform WITH OWNER infostore_carbon;

CREATE SCHEMA platform_data;

ALTER SCHEMA platform_data OWNER TO infostore_carbon;

SET SEARCH_PATH TO platform_data;
