------------------------------------------------------------------------------------------------------------------
-- Create base DB schema
------------------------------------------------------------------------------------------------------------------
create schema if not exists car_management;

set search_path to public;
create extension if not exists pgcrypto schema public;
