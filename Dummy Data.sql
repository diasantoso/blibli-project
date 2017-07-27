--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-07-27 11:19:01

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
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 49849)
-- Name: booking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE booking (
    id_booking character varying(255) NOT NULL,
    added_date date,
    date_meeting date,
    description character varying(255),
    end_time time without time zone,
    start_time time without time zone,
    status integer,
    status_booking character varying(255),
    subject character varying(255),
    employee_id character varying(255) NOT NULL,
    room_id character varying(255) NOT NULL,
    pic_contact character varying(255)
);


ALTER TABLE booking OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 49857)
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
-- TOC entry 187 (class 1259 OID 49865)
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
-- TOC entry 188 (class 1259 OID 49873)
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
-- TOC entry 189 (class 1259 OID 49881)
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
-- TOC entry 2153 (class 0 OID 49849)
-- Dependencies: 185
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO booking (id_booking, added_date, date_meeting, description, end_time, start_time, status, status_booking, subject, employee_id, room_id, pic_contact) VALUES ('1', '2017-07-18', '2018-07-21', 'Pertemuan Besar', '15:00:00', '12:00:00', 1, '1', 'subyek', '402881e85cee7df1015cee87a0880001', '1', NULL);
INSERT INTO booking (id_booking, added_date, date_meeting, description, end_time, start_time, status, status_booking, subject, employee_id, room_id, pic_contact) VALUES ('3', '2017-07-19', '2018-07-21', 'tanggal meeting sebelum', '18:00:00', '20:00:00', 1, '1', 'mencoba sebelum', '402881ea5d565475015d5655f7a50000', '1', NULL);
INSERT INTO booking (id_booking, added_date, date_meeting, description, end_time, start_time, status, status_booking, subject, employee_id, room_id, pic_contact) VALUES ('5', '2017-07-19', '2018-07-21', 'Mencoba tanggal hari itu, tapi jam mulai- jam selesai sudah lewat', '20:00:00', '16:00:00', 1, '1', 'no subjek', '402881e85cee7df1015cee87a0880001', '1', NULL);
INSERT INTO booking (id_booking, added_date, date_meeting, description, end_time, start_time, status, status_booking, subject, employee_id, room_id, pic_contact) VALUES ('2', '2017-07-19', '2018-07-21', 'tanggal meeting sama', '22:00:00', '20:00:00', 1, '1', 'mencoba', '402881ea5d565475015d5655f7a50000', '1', NULL);
INSERT INTO booking (id_booking, added_date, date_meeting, description, end_time, start_time, status, status_booking, subject, employee_id, room_id, pic_contact) VALUES ('4', '2017-07-19', '2018-07-21', 'Mencoba tanggal hari itu, tapi jam mulai sudah lewat sedangkan jam selesai belum', '22:00:00', '16:00:00', 1, '1', 'no subjek', '402881e85cee7df1015cee87a0880001', '1', NULL);
INSERT INTO booking (id_booking, added_date, date_meeting, description, end_time, start_time, status, status_booking, subject, employee_id, room_id, pic_contact) VALUES ('7', '2017-07-21', '2017-08-20', 'coba nampil ruangan available berdasar kantor', '22:00:00', '20:00:00', 1, '1', '1', '402881ea5d565475015d5655f7a50000', '402881e85cf94629015cf95d80480007', '08999999');


--
-- TOC entry 2154 (class 0 OID 49857)
-- Dependencies: 186
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('402881e85cee7df1015cee879ffb0000', 'dias@gmail.com', 'Dias', 'dias', 'Admin', 1);
INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('402881e85cee7df1015cee87a0880001', 'audine@gmail.com', 'Audine', 'audine', 'Admin', 1);
INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('402881ea5d565475015d5655f7a50000', 'amelly@gmail.com', 'Amelly', 'amelly', 'Employee', 1);
INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('402881ea5d56d321015d56d404750000', 'user2@gmail.com', 'User2', 'user2', 'Employee', 1);
INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('402881ea5d56cdd9015d56d0524f0000', 'user1@gmail.com', 'User1', 'user1', 'Employee', 0);
INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('402881ea5d56d6a6015d56d853990000', 'user3@gmail.com', 'User3', 'user3', 'Employee', 1);
INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('ff8080815d58fc1d015d59001eca0000', 'user5@gmail.com', 'User5', 'user5', 'Employee', 1);
INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('402881ea5d5bac9f015d5bb1fb030000', 'user6@gmail.com', 'user6', 'user6', 'Employee', 1);
INSERT INTO employee (id_employee, email, name, password, role, status) VALUES ('402881ea5d5bb33c015d5bb3c71c0000', 'user7@gmail.com', 'user7', 'user7', 'Employee', 1);


--
-- TOC entry 2155 (class 0 OID 49865)
-- Dependencies: 187
-- Data for Name: office; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('4028abcf5ba063ff015ba06465d80000', 'Auidn', 'AaAa', 'Audinw', 1, '12313123');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('ff8080815c04eb2f015c04ecaa920004', 'jalan', 'jalan999', 'office 2', 1, '899999');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('1', 'jalan maguwo', 'jogja', 'kantor maguwo', 1, '0821111111');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('402881e85cee7df1015cee87a08f0002', 'Jalan Tubun Raya no 100', 'Jakarta', 'KS. Tubun', 1, '778899');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('402881e85cee7df1015cee87a0ab0003', 'Jalan Thamrin no 99', 'Jakarta', 'KS. Thamrin', 1, '123456');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('402881e85d181c6c015d181dae0b0000', 'Alamat 1', 'Kota 1', 'Kantor 1', 1, '11111');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('402881e85d181c6c015d181de6230001', 'Alamat 2', 'Kota 2', 'Kantor 2', NULL, '22222');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('402881e85d181c6c015d181e2c9a0002', 'e', '1', 'q', 1, '1');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('402881e85d181c6c015d181e5cb50003', 'u1', 'u', 'u', NULL, '12');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('402881e85d1826e2015d1827cdec0000', 'alamat 1', 'kota 1', 'coba', 1, '11111');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('402881e85d1826e2015d182828750001', 'alamat 2', 'kota 2', 'coba 2 deh', 1, '1234');
INSERT INTO office (id_office, address, city, name, status, telephone) VALUES ('ff8080815d4e9773015d4ec9fd3c0002', 'Jalan Kaliurang', 'Yogyakarta', 'Kantor Blibli', 1, '024777777');


--
-- TOC entry 2156 (class 0 OID 49873)
-- Dependencies: 188
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('1', 1245, '1', '1', '1245', '1245', 1, '4028abcf5ba063ff015ba06465d80000');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8a20831d5be7b6f0015be7b800080000', 12, '1', '1', 'room A', '12345', 1, '4028abcf5ba063ff015ba06465d80000');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881955be8fbb0015be8fd5db80000', 1230, '1', '1', 'Room 45', '089', 1, '4028abcf5ba063ff015ba06465d80000');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('1245', 1245, '1', '1', '1245', '12453', 1, '4028abcf5ba063ff015ba06465d80000');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c052461015c052c86460001', 20, '1', '1', 'A', '123456', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c05367f015c053866f60000', 20, '1', '1', 'Room 3', '123456', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c053d06015c053d871c0000', 25, '1', '1', 'Room 4', '12345678', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c05e336015c05e5561f0001', 12, '1', '1', 'Room 19', '12345', 0, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c05e336015c05e43ed80000', 12, '1', '1', 'Room 101', '1212121', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c05ebb4015c05ec08b80000', 1, '1', '1', '1233', '11', 0, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c066269015c066301d90000', 1000, '1', '1', 'Room111', '1212121', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c0663ee015c06644bf60000', 12, '1', '1', 'room112', '12121211', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c0663ee015c066740170001', 12, '1', '1', 'room 102', '12345', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c0668b8015c066918280000', 12, '1', '1', 'room180', '1212', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c066cd8015c066d74ae0000', 19, '1', '1', 'Room 123', '098777', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c066cd8015c06771ae40001', 10, '1', '1', 'Room 189', '1111111', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c067bd6015c067c5dd50000', 10, '1', '1', 'Room123', '092828282', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c067dda015c067e60610000', 100, '1', '1', 'Room200', '087666666', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('8ab2984d5c067f86015c06803e0d0000', 12, '1', '1', 'Room 201', '6767530', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('ff8080815c06b2a5015c06b367b70000', 10, '1', '1', '123', '12121', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('4028e4b05c3a941b015c3a96918f0000', 1000, '1', '1', '1', '12345', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf94629015cf94974430000', 10, '1', '1', 'Ruang23', '10008', 1, '402881e85cee7df1015cee87a08f0002');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf94629015cf95913350003', 120, '1', '1', 'ruangan', '987543', 1, '402881e85cee7df1015cee87a08f0002');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf94629015cf95bb1b30005', 12, '1', '0', 'cobaruang', '13331', 1, '402881e85cee7df1015cee87a08f0002');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf94629015cf95e132a0009', 123, '1', '1', 'cobalagii', '132131', 1, '4028abcf5ba063ff015ba06465d80000');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf94629015cf95d80480007', 13, '1', '1', 'cobaruang20', '131311', 1, 'ff8080815c04eb2f015c04ecaa920004');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf94629015cf9653d1b000c', 100, '1', '1', 'coba3', '111111', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf96e92015cf970334d0000', 12, '1', '1', 'RuangCoba', '121212', 1, '402881e85cee7df1015cee87a08f0002');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf973ef015cf975068b0000', 127, '1', '1', 'RuangTry', '127', 1, '4028abcf5ba063ff015ba06465d80000');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf973ef015cf9778c450002', 134, '1', '1', 'Ruang try2', '123', 1, '402881e85cee7df1015cee87a0ab0003');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf973ef015cf97a94560003', 23, '1', '1', 'Ruang try23', '23', 1, 'ff8080815c04eb2f015c04ecaa920004');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf973ef015cf97d1b4a0005', 233, '1', '1', 'Ruang try233', '233', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf973ef015cf98c4e8d0006', 12, '1', '1', 'Ruangwaktu', '12121', 1, 'ff8080815c04eb2f015c04ecaa920004');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85cf973ef015cf98d62420009', 123, '1', '1', 'ruanglagi', '123', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85d1832e3015d183454310000', 10, '1', '1', 'Ruang 1', '1', 1, 'ff8080815c04eb2f015c04ecaa920004');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881e85d1832e3015d1834fc720006', 200, '1', '1', 'Cobasatulagi', '121', 1, '402881e85d181c6c015d181e2c9a0002');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('402881ea5d2cad18015d2cae70a10000', 100, '1', '1', 'Ruangan baru buat', '1111', 1, '1');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('ff8080815d4e9773015d4ec8d69b0000', 20, '1', '1', 'Room Blibli', '418282', 1, '402881e85cee7df1015cee87a08f0002');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('ff8080815d5f18d3015d5f1e5f230000', 120, '1', '1', 'cek gambar', '12', 1, '402881e85cee7df1015cee87a08f0002');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('ff8080815d5f29de015d5f2aa9800000', 16, '1', '1', 'cek gambar 2', '1213523', 1, '4028abcf5ba063ff015ba06465d80000');
INSERT INTO room (id_room, capacity, is_conference, is_projector, name, number_extension, status, office_id) VALUES ('2', 15, '1', '1', 'ruang', '22222', 1, 'ff8080815c04eb2f015c04ecaa920004');


--
-- TOC entry 2157 (class 0 OID 49881)
-- Dependencies: 189
-- Data for Name: room_image; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO room_image (id_room_image, image_address, image_description, room_id) VALUES ('ff8080815d5f18d3015d5f1e5f810001', 'room-opeTV-1.jpg', 'Room Image', 'ff8080815d5f18d3015d5f1e5f230000');
INSERT INTO room_image (id_room_image, image_address, image_description, room_id) VALUES ('ff8080815d5f29de015d5f2aa9fb0001', 'room-ywm7B-4.jpg', 'Room Image', 'ff8080815d5f29de015d5f2aa9800000');


--
-- TOC entry 2023 (class 2606 OID 49856)
-- Name: booking booking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (id_booking);


--
-- TOC entry 2025 (class 2606 OID 49864)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id_employee);


--
-- TOC entry 2027 (class 2606 OID 49872)
-- Name: office office_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY office
    ADD CONSTRAINT office_pkey PRIMARY KEY (id_office);


--
-- TOC entry 2031 (class 2606 OID 49888)
-- Name: room_image room_image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY room_image
    ADD CONSTRAINT room_image_pkey PRIMARY KEY (id_room_image);


--
-- TOC entry 2029 (class 2606 OID 49880)
-- Name: room room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY room
    ADD CONSTRAINT room_pkey PRIMARY KEY (id_room);


--
-- TOC entry 2032 (class 2606 OID 49889)
-- Name: booking fk1dnnhqt4wl3v6a72hxiarf7lg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY booking
    ADD CONSTRAINT fk1dnnhqt4wl3v6a72hxiarf7lg FOREIGN KEY (employee_id) REFERENCES employee(id_employee);


--
-- TOC entry 2034 (class 2606 OID 49899)
-- Name: room fkb0a0xuke24rvwdoqmiuiehfqo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY room
    ADD CONSTRAINT fkb0a0xuke24rvwdoqmiuiehfqo FOREIGN KEY (office_id) REFERENCES office(id_office);


--
-- TOC entry 2035 (class 2606 OID 49904)
-- Name: room_image fkcme41omxvwoj00bhqk7fwt70v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY room_image
    ADD CONSTRAINT fkcme41omxvwoj00bhqk7fwt70v FOREIGN KEY (room_id) REFERENCES room(id_room);


--
-- TOC entry 2033 (class 2606 OID 49894)
-- Name: booking fkq83pan5xy2a6rn0qsl9bckqai; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY booking
    ADD CONSTRAINT fkq83pan5xy2a6rn0qsl9bckqai FOREIGN KEY (room_id) REFERENCES room(id_room);


-- Completed on 2017-07-27 11:19:01

--
-- PostgreSQL database dump complete
--

