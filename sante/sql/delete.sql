delete from citoyen_allergie; 
delete from allergie; 
delete from citoyen_maladie;
delete from maladie; 
delete from operation; 
delete from partie_corps; 
delete from citoyen ; 

alter sequence allergie_idallergie_seq restart with 1; 
alter sequence maladie_idmaladie_seq  restart with 1; 
alter sequence operation_idoperation_seq   restart with 1; 
alter sequence partie_corps_idpartiecorps_seq  restart with 1; 