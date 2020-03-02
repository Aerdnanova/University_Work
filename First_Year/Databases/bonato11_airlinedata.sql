INSERT into AIRPORT values('YYZ','Pearson Airport','Toronto','ON');
INSERT into AIRPORT values('YTZ','Island Airport','Toronto','ON');
INSERT into AIRPORT values('YQT','Thunder Bay Airport','Thunder Bay','ON');
INSERT into AIRPORT values('YQG','Windsor Airport','Windsor','ON');
INSERT into AIRPORT values('YYC','Calgary Airport','Calgary','AB');
COMMIT;
INSERT into FLIGHT values('WJ250','WestJet','3');
INSERT into FLIGHT values('WJ261','WestJet','4');
INSERT into FLIGHT values('AC275','Air Canada', '2');
INSERT into FLIGHT values('AC300','Air Canada','3');
INSERT into FLIGHT values('AC320','Air Canada','2');
INSERT into FLIGHT values('PA233','Porter Airline','5');
INSERT into FLIGHT values('PA280','Porter Airline','4');
COMMIT;
INSERT into FLIGHT_LEG values('WJ250','1','YQG','08:00','YYZ','09:00');
INSERT into FLIGHT_LEG values('WJ250','2','YYZ','12:00','YYC','17:00');
INSERT into FLIGHT_LEG values('AC275','1','YQT','10:00','YYZ','11:00');
INSERT into FLIGHT_LEG values('AC275','2','YYZ','13:00','YQG','14:00');
INSERT into FLIGHT_LEG values('PA233','1','YQG','16:00','YYZ','17:00');
INSERT into FLIGHT_LEG values('PA280','1','YYZ','11:00','YQG','12:00');
COMMIT;
INSERT into LEG_INSTANCE values('WJ250','1','15-JAN-17',200,'Boeing_777','YQG','8:00','YYZ','8:50');
INSERT into LEG_INSTANCE values('WJ250','2','15-JAN-17',200,'Boeing_777','YYZ','12:30','YYC','16:50');
INSERT into LEG_INSTANCE values('AC275','1','10-JAN-17',60,'Airbus_200','YQT','10:00','YYZ','11:00');
INSERT into LEG_INSTANCE values('AC275','2','10-JAN-17',60,'Airbus_200','YYZ','13:00','YQG','14:00');
INSERT into LEG_INSTANCE values('PA233','1','30-JAN-17',120,'Boeing_737','YQG','16:00','YYZ','17:00');
INSERT into LEG_INSTANCE values('PA280','1','20-JAN-17',120,'Boeing_737','YYZ','11:00','YQG','12:00');
COMMIT;
INSERT into FARES values('WJ250','F1','$250','None');
INSERT into FARES values('WJ250','F2','$350','None');
INSERT into FARES values('AC275','F1','$275','Non-refundable');
INSERT into FARES values('AC275','F2','$300','Non-refundable');
INSERT into FARES values('PA233','F3','$150','None');
INSERT into FARES values('PA280','F3','$150','None');
COMMIT;
INSERT into SEAT_RESERVATION values('WJ250','1','15-JAN-17','20A','Mariane Mooer','519-253-3000');
INSERT into SEAT_RESERVATION values('WJ250','2','15-JAN-17','13D','Mariane Mooer','519-253-3000');
INSERT into SEAT_RESERVATION values('WJ250', '1','15-JAN-17','6A','Tony Appa','226-253-4000');
INSERT into SEAT_RESERVATION values('WJ250','2','15-JAN-17','7D','Tony Appa','226-253-4000');
INSERT into SEAT_RESERVATION values('WJ250','1','15-JAN-17','6B','Karen Appa','226-253-4000');
INSERT into SEAT_RESERVATION values('WJ250','2','15-JAN-17','7C','Karen Appa','226-253-4000');
INSERT into SEAT_RESERVATION values('AC275','1','10-JAN-17','5C','Mark Black','226-212-5341');
INSERT into SEAT_RESERVATION values('AC275','2','10-JAN-17','14B','Mark Black','226-212-5341');
INSERT into SEAT_RESERVATION values('PA233','1','30-JAN-17','5A','Peter Opo','519-444-1234');
INSERT into SEAT_RESERVATION values('PA280','1','20-JAN-17','16D','Chris Natta','226-123-5555');
COMMIT;
