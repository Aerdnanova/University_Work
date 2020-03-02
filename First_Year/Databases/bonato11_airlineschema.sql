CREATE TABLE AIRPORT(
Airport_Code varchar2(3),
Name varchar2(30),
City varchar2(20),
State varchar(3),
primary key(Airport_Code)
);
CREATE table FLIGHT(
Flight_number varchar2(5),
Airline varchar2(20),
Weekdays varchar2(20),
primary key(Flight_number)
);
CREATE table FLIGHT_LEG(
Flight_number varchar2(5),
Leg_number varchar2(2),
Departure_airport_code varchar2(3),
Scheduled_departure_time varchar2(20),
Arrival_airport_code varchar2(5),
Scheduled_arrival_time varchar2(20),
foreign key (Departure_airport_code) references AIRPORT(Airport_Code),
foreign key (Arrival_airport_code) references AIRPORT(Airport_Code),
foreign key (Flight_number) references FLIGHT(Flight_number),
primary key(Flight_number, Leg_number)
);
CREATE table LEG_INSTANCE(
Flight_number varchar2(5),
Leg_number varchar2(2),
FDate varchar2(20),
Num_available_seats number(3),
Airplane_id varchar2(15),
Departure_airport_code varchar2(3),
Departure_time varchar2(5),
Arrival_airport_code varchar2(5),
Arrival_time varchar2(5),
foreign key (Departure_airport_code) references AIRPORT(Airport_Code),
foreign key (Arrival_airport_code) references AIRPORT(Airport_Code),
primary key (Flight_number, Leg_number, FDate)
);
CREATE table FARES(
Flight_number varchar2(5),
Fare_code varchar2(2),
Amount varchar2(5),
Restrictions varchar2(15),
foreign key (Flight_number) references FLIGHT(Flight_number),
primary key (Flight_number, Fare_code)
);
CREATE table SEAT_RESERVATION(
Flight_number varchar2(5),
Leg_number varchar2(2),
FDate varchar2(20),
Seat_number varchar2(5),
Customer_name varchar2(20),
Customer_phone varchar(12),
foreign key (Flight_number, Leg_number, FDate) references LEG_INSTANCE(Flight_number, Leg_number, FDate)
);
