--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-08-09 12:49:09

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2164 (class 1262 OID 24576)
-- Name: databaseFuture; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "databaseFuture" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE "databaseFuture" OWNER TO postgres;

\connect "databaseFuture"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 58351)
-- Name: booking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE booking (
    id_booking character varying(255) NOT NULL,
    added_date date,
    booking_ticket character varying(255),
    date_meeting date,
    description character varying(255),
    end_time time without time zone,
    pic_contact character varying(255),
    special_request character varying(255),
    start_time time without time zone,
    status integer,
    subject character varying(255),
    employee_id character varying(255) NOT NULL,
    room_id character varying(255) NOT NULL
);


ALTER TABLE booking OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 58359)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE employee (
    id_employee character varying(255) NOT NULL,
    email character varying(255),
    name character varying(255),
    password character varying(255),
    role character varying(255),
    status integer
);


ALTER TABLE employee OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 58367)
-- Name: office; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE office (
    id_office character varying(255) NOT NULL,
    address character varying(255),
    city character varying(255),
    name character varying(255),
    status integer,
    telephone character varying(255)
);


ALTER TABLE office OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 58375)
-- Name: room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE room (
    id_room character varying(255) NOT NULL,
    capacity integer,
    is_conference character varying(255),
    is_projector character varying(255),
    name character varying(255),
    number_extension character varying(255),
    status integer,
    office_id character varying(255) NOT NULL
);


ALTER TABLE room OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 58383)
-- Name: room_image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE room_image (
    id_room_image character varying(255) NOT NULL,
    image_address character varying(255),
    image_description character varying(255),
    room_id character varying(255) NOT NULL
);


ALTER TABLE room_image OWNER TO postgres;

--
-- TOC entry 2155 (class 0 OID 58351)
-- Dependencies: 185
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO booking (id_booking, added_date, booking_ticket, date_meeting, description, end_time, pic_contact, special_request, start_time, status, subject, employee_id, room_id) VALUES ('4028abcf5dc0eda1015dc0f0c2860001', '2017-08-08', 'BOOK-2', '2017-08-31', 'Booking Ruangan Tubun 1 (extend)', '10:00:00', 'Pak Pak', 'Minuman', '09:01:00', 1, 'meeting', '4028abcf5dc0bff8015dc0c8e6b40000', '4028abcf5dc0bff8015dc0d3ca310004');
INSERT INTO booking (id_booking, added_date, booking_ticket, date_meeting, description, end_time, pic_contact, special_request, start_time, status, subject, employee_id, room_id) VALUES ('402809e55dc190bd015dc19181350001', '2017-08-08', 'BOOK-6', '2017-08-31', 'Booking Ruangan Tubun 1 (extend)', '09:00:00', 'Pak Pak', 'Minuman', '09:01:00', 0, 'meeting', '4028abcf5dc0bff8015dc0c8e6b40000', '4028abcf5dc0bff8015dc0d3ca310004');
INSERT INTO booking (id_booking, added_date, booking_ticket, date_meeting, description, end_time, pic_contact, special_request, start_time, status, subject, employee_id, room_id) VALUES ('402809e55dc190bd015dc191436c0000', '2017-08-08', 'BOOK-5', '2017-08-31', 'Booking Ruangan Tubun 1 (extend)', '09:00:00', 'Pak Pak', 'Minuman', '09:01:00', 0, 'meeting', '4028abcf5dc0bff8015dc0c8e6b40000', '4028abcf5dc0bff8015dc0d3ca310004');
INSERT INTO booking (id_booking, added_date, booking_ticket, date_meeting, description, end_time, pic_contact, special_request, start_time, status, subject, employee_id, room_id) VALUES ('4028abcf5dc13aca015dc13db9db0001', '2017-08-08', 'BOOK-4', '2017-08-31', 'Booking Ruangan Tubun 1 (extend) (extend)', '11:00:00', 'Pak Pak', 'Minuman', '10:01:00', 0, 'meeting', '4028abcf5dc0bff8015dc0c8e6b40000', '4028abcf5dc0bff8015dc0d3ca310004');
INSERT INTO booking (id_booking, added_date, booking_ticket, date_meeting, description, end_time, pic_contact, special_request, start_time, status, subject, employee_id, room_id) VALUES ('4028abcf5dc13aca015dc13c86270000', '2017-08-08', 'BOOK-3', '2017-08-31', 'Booking Ruangan Tubun 1 (extend)', '09:00:00', 'Pak Pak', 'Minuman', '09:01:00', 0, 'meeting', '4028abcf5dc0bff8015dc0c8e6b40000', '4028abcf5dc0bff8015dc0d3ca310004');
INSERT INTO booking (id_booking, added_date, booking_ticket, date_meeting, description, end_time, pic_contact, special_request, start_time, status, subject, employee_id, room_id) VALUES ('402881955dc27b69015dc2837f680000', '2017-08-08', 'BOOK-7', '2017-08-31', 'Booking Ruangan Tubun 1 (extend) (extend)', '11:00:00', 'Pak Pak', 'Minuman', '10:01:00', 1, 'meeting', '4028abcf5dc0bff8015dc0c8e6b40000', '4028abcf5dc0bff8015dc0d3ca310004');
INSERT INTO booking (id_booking, added_date, booking_ticket, date_meeting, description, end_time, pic_contact, special_request, start_time, status, subject, employee_id, room_id) VALUES ('4028abcf5dc0eda1015dc0efc4f20000', '2017-08-08', 'BOOK-8', '2017-08-31', 'Booking Ruangan Tubun 1', '10:00:00', 'Pak Pak', 'Minuman', '09:00:00', 1, 'meeting', '4028abcf5dc0bff8015dc0c8e6b40000', '4028abcf5dc0bff8015dc0d4350d0006');
INSERT INTO booking (id_booking, added_date, booking_ticket, date_meeting, description, end_time, pic_contact, special_request, start_time, status, subject, employee_id, room_id) VALUES ('402881955dc2fd28015dc53378060001', '2017-08-09', 'BOOK-8', '2017-08-26', 'Test book kantor tubun 1', '10:00:00', '0899999', 'Minuman dingin', '09:00:00', 0, 'Meeting kantor Tubun 1', '402881955dc2fd28015dc52f8c120000', '4028abcf5dc0bff8015dc0d3ca310004');
INSERT INTO booking (id_booking, added_date, booking_ticket, date_meeting, description, end_time, pic_contact, special_request, start_time, status, subject, employee_id, room_id) VALUES ('402881955dc2fd28015dc5348e6e0002', '2017-08-09', 'BOOK-9', '2017-08-25', 'Coba Extend', '12:00:00', 'Extend', 'Minuman', '10:00:00', 1, 'Extend', '402881955dc2fd28015dc52f8c120000', '4028abcf5dc0bff8015dc0d3ca310004');
INSERT INTO booking (id_booking, added_date, booking_ticket, date_meeting, description, end_time, pic_contact, special_request, start_time, status, subject, employee_id, room_id) VALUES ('402881955dc2fd28015dc53532f00003', '2017-08-09', 'BOOK-11', '2017-08-25', 'Coba Extend (extend)', '13:00:00', 'Extend', 'Minuman', '11:00:00', 1, 'Extend', '402881955dc2fd28015dc52f8c120000', '4028abcf5dc0bff8015dc0d4350d0006');


--
-- TOC entry 2156 (class 0 OID 58359)
-- Dependencies: 186
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('4028abcf5dc0bff8015dc0c8e6b40000', 'amelly@gmail.com', 'Amelly', 'amelly', 'Employee', 1);
INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('2', 'audin@gmail.com', 'audin', 'audin', 'Admin', 1);
INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('402881955dc2fd28015dc52f8c120000', 'user1@gmail.com', 'User1', 'user1', 'Employee', 1);


--
-- TOC entry 2157 (class 0 OID 58367)
-- Dependencies: 187
-- Data for Name: office; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('4028abcf5dc0bff8015dc0cf3fff0001', 'Jalan Tubun', 'Tubun City Metro', 'Kantor Tubun', 1, '0878882311');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('4028abcf5dc0bff8015dc0d14c8b0003', 'Jalan Thamrin City', 'Thamrin City', 'Kantor Thamrin', 1, '089777222');


--
-- TOC entry 2158 (class 0 OID 58375)
-- Dependencies: 188
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('4028abcf5dc0bff8015dc0d3ca310004', 20, '1', '1', 'Ruangan Tubun 1', '51111', 1, '4028abcf5dc0bff8015dc0cf3fff0001');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('4028abcf5dc0bff8015dc0d4350d0006', 16, '1', '1', 'Ruangan Tubun 2', '11111', 1, '4028abcf5dc0bff8015dc0cf3fff0001');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('4028abcf5dc0bff8015dc0d512920008', 60, '0', '0', 'Ruangan Tubun 3', '44444', 1, '4028abcf5dc0bff8015dc0cf3fff0001');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('4028abcf5dc0bff8015dc0d59bf5000a', 24, '1', '1', 'Ruangan Thamrin 1', '32232', 1, '4028abcf5dc0bff8015dc0d14c8b0003');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('4028abcf5dc0bff8015dc0d6071d000c', 20, '1', '1', 'Ruangan Thamrin 2', '33333', 1, '4028abcf5dc0bff8015dc0d14c8b0003');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('4028abcf5dc0bff8015dc0d72188000e', 40, '0', '0', 'Ruangan Thamrin 3', '444556', 1, '4028abcf5dc0bff8015dc0d14c8b0003');


--
-- TOC entry 2159 (class 0 OID 58383)
-- Dependencies: 189
-- Data for Name: room_image; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO room_image (id_room_image, image_address, image_description, room_id) VALUES ('4028abcf5dc0bff8015dc0d3cddf0005', 'room-acniz-4.jpg', 'Room Image', '4028abcf5dc0bff8015dc0d3ca310004');
INSERT INTO room_image (id_room_image, image_address, image_description, room_id) VALUES ('4028abcf5dc0bff8015dc0d438550007', 'room-Vv8EE-1.jpg', 'Room Image', '4028abcf5dc0bff8015dc0d4350d0006');
INSERT INTO room_image (id_room_image, image_address, image_description, room_id) VALUES ('4028abcf5dc0bff8015dc0d516360009', 'room-ZNniH-4.jpg', 'Room Image', '4028abcf5dc0bff8015dc0d512920008');
INSERT INTO room_image (id_room_image, image_address, image_description, room_id) VALUES ('4028abcf5dc0bff8015dc0d5a124000b', 'room-GVhJ7-4.jpg', 'Room Image', '4028abcf5dc0bff8015dc0d59bf5000a');
INSERT INTO room_image (id_room_image, image_address, image_description, room_id) VALUES ('4028abcf5dc0bff8015dc0d60c76000d', 'room-Asa1u-4.jpg', 'Room Image', '4028abcf5dc0bff8015dc0d6071d000c');
INSERT INTO room_image (id_room_image, image_address, image_description, room_id) VALUES ('4028abcf5dc0bff8015dc0d724b7000f', 'room-wP6Mw-Etude-House-Logo-vector-image.png', 'Room Image', '4028abcf5dc0bff8015dc0d72188000e');


--
-- TOC entry 2023 (class 2606 OID 58358)
-- Name: booking booking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (id_booking);


--
-- TOC entry 2025 (class 2606 OID 58366)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id_employee);


--
-- TOC entry 2029 (class 2606 OID 58374)
-- Name: office office_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY office
    ADD CONSTRAINT office_pkey PRIMARY KEY (id_office);


--
-- TOC entry 2033 (class 2606 OID 58390)
-- Name: room_image room_image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY room_image
    ADD CONSTRAINT room_image_pkey PRIMARY KEY (id_room_image);


--
-- TOC entry 2031 (class 2606 OID 58382)
-- Name: room room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY room
    ADD CONSTRAINT room_pkey PRIMARY KEY (id_room);


--
-- TOC entry 2027 (class 2606 OID 58392)
-- Name: employee uk_fopic1oh5oln2khj8eat6ino0; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT uk_fopic1oh5oln2khj8eat6ino0 UNIQUE (email);


--
-- TOC entry 2034 (class 2606 OID 58393)
-- Name: booking fk1dnnhqt4wl3v6a72hxiarf7lg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY booking
    ADD CONSTRAINT fk1dnnhqt4wl3v6a72hxiarf7lg FOREIGN KEY (employee_id) REFERENCES employee(id_employee);


--
-- TOC entry 2036 (class 2606 OID 58403)
-- Name: room fkb0a0xuke24rvwdoqmiuiehfqo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY room
    ADD CONSTRAINT fkb0a0xuke24rvwdoqmiuiehfqo FOREIGN KEY (office_id) REFERENCES office(id_office);


--
-- TOC entry 2037 (class 2606 OID 58408)
-- Name: room_image fkcme41omxvwoj00bhqk7fwt70v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY room_image
    ADD CONSTRAINT fkcme41omxvwoj00bhqk7fwt70v FOREIGN KEY (room_id) REFERENCES room(id_room);


--
-- TOC entry 2035 (class 2606 OID 58398)
-- Name: booking fkq83pan5xy2a6rn0qsl9bckqai; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY booking
    ADD CONSTRAINT fkq83pan5xy2a6rn0qsl9bckqai FOREIGN KEY (room_id) REFERENCES room(id_room);


-- Completed on 2017-08-09 12:49:09

--
-- PostgreSQL database dump complete
--
