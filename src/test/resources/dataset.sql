INSERT INTO Cuenta (codigo, email,estado, password ) VALUES (1, 'pepito@email.com',0, 'Admin123');
INSERT INTO Cuenta (codigo, email,estado, password) VALUES (2, 'juanita@email.com',0, 'Admin95');
INSERT INTO Cuenta (codigo, email,estado, password) VALUES (3, 'luisalopez@gmail.com',0, 'luisa2023');
INSERT INTO Cuenta (codigo, email,estado, password) VALUES (4 ,'pedrogonzalez@gmail.com',0, 'pedro2025');
INSERT INTO Cuenta (codigo, email,estado, password) VALUES (5, 'mariaperez@gmail.com',0, 'maria20');
INSERT INTO Cuenta (codigo, email,estado, password) VALUES (6, 'carlosrodriguez@gmail.com',0, 'carro20');
INSERT INTO Cuenta (codigo, email,estado, password) VALUES (7, 'lauragonzalez@gmail.com',0, 'lalala21');
INSERT INTO Cuenta (codigo, email,estado, password) VALUES (8, 'juanfigueroa@clinicajpm.com',0, 'figueroa23');
INSERT INTO Cuenta (codigo, email,estado, password) VALUES (9, 'carlosruiz@clinicajpm.com',0, 'caruiz95');
INSERT INTO Cuenta (codigo, email,estado, password)VALUES (10, 'ganudi@clinicajpm.com',0, 'ganudi30');
INSERT INTO Cuenta (codigo, email,estado, password) VALUES (11, 'andresramirez@clinicajpm.com',0, 'andrre10');
INSERT INTO Cuenta (codigo, email,estado, password)VALUES (12, 'monicavargas@clinicajpm.com',0, 'mysecretpw');

INSERT INTO administrador values(1);
INSERT INTO administrador  values(2);

INSERT INTO paciente (cedula,ciudad,nombre,telefono,url_Foto,alergias,eps,fecha_Nacimiento,tipo_Sangre,codigo)
VALUES (936547956,0,'Luisa Lopez Gil','3211548880', 'http://fotolaura.com/laura.jpg','Sin alergias',0,'1995-11-28',0,3);
INSERT INTO paciente (cedula,ciudad,nombre,telefono,url_Foto,alergias,eps,fecha_Nacimiento,tipo_Sangre,codigo)
VALUES (200963258, 2,'Pedro pablo Gonzalez Zapata', '3002453219','http://pablo.com/pabloz.jpg','alergia al polen',0,'1990-08-15',0,4);
INSERT INTO paciente (cedula,ciudad,nombre,telefono,url_Foto,alergias,eps,fecha_Nacimiento,tipo_Sangre,codigo)
VALUES(1009632582,3, 'Maria Perez Perez','6067429987','http://foto1.com/foto1.jpg','sin alergias conocidas',4,'1988-03-20',6,5);
INSERT INTO paciente (cedula,ciudad,nombre,telefono,url_Foto,alergias,eps,fecha_Nacimiento,tipo_Sangre,codigo)
values( 338521427,3,'Carlos Rodriguez','6067433321','http://carlos.com/fotocarlos.jpg', 'alergia al ibuprofeno',1, '2000-05-10',7,6);
INSERT INTO paciente (cedula,ciudad,nombre,telefono,url_Foto,alergias,eps,fecha_Nacimiento,tipo_Sangre,codigo)
values(44546821,3,'Laura Gonzalez Sanchez','6067654321','http://foto.com/fotolala.jpg','Sin alergias', 1,'1998-12-05',0,7);

insert into medico(cedula,ciudad,nombre,telefono,url_Foto,especialidad,codigo)
values(100400569,2,'Dr. Juan Pérez Camacho','3211234567','http://doctorCamacho.com/doctorCamacho.jpg',0,8);
insert into medico (cedula,ciudad,nombre,telefono,url_Foto,especialidad,codigo)
values(1097402115,2,'Dr. Carlos Ruiz Montes', '3002589631', 'http://fotodoctor.com/doctorRuiz.jpg',0,9);
insert into medico (cedula,ciudad,nombre,telefono,url_Foto,especialidad,codigo)
values(448003020,2, 'Dra. Ana García Garcia', '3209636541', 'http://fotodoctora.com/doctoraAna.jpg',5,10);
insert into medico (cedula,ciudad,nombre,telefono,url_Foto,especialidad,codigo)
values( 339632545,5, 'Dr. Andres Ramirez', '3119517532', 'http://imagendoctor.com/doctorRamirez.jpg',8,11);
insert into medico (cedula,ciudad,nombre,telefono,url_Foto,especialidad,codigo)
values(933567416,2,'Dra. Monica Vargas Vargas', '606742369', 'http://fotoDra.com/doctoraMonica.jpg',3,12);



INSERT INTO Horario_Medico (codigo,dia,hora_inicio,hora_fin,medico_codigo)
VALUES (1, '2023-10-31','2023-10-31 08:00:00','2023-10-31 12:00:00', 8);
INSERT INTO Horario_Medico (codigo,dia,hora_inicio,hora_fin,medico_codigo)
VALUES (2, '2023-12-18','2023-12-18 10:00:00', '2023-12-18 14:00:00', 8);
INSERT INTO Horario_Medico (codigo,dia,hora_inicio,hora_fin,medico_codigo)
VALUES (3, '2023-11-25,','2023-11-25 13:00:00','2023-11-25 16:00:00', 9);
INSERT INTO Horario_Medico (codigo,dia,hora_inicio,hora_fin,medico_codigo)
VALUES (4, '2023-11-26','2023-11-26 09:00:00','2023-11-26 12:00:00', 12);
INSERT INTO Horario_Medico (codigo,dia,hora_inicio,hora_fin,medico_codigo)
VALUES (5, '2023-12-27','2023-12-27 14:00:00', '2023-12-27 15:00:00', 11);

INSERT INTO dia_libre (codigo,dia,medico_codigo) VALUES (1, '2023-10-31', 8);
INSERT INTO dia_libre (codigo,dia,medico_codigo) VALUES (2,'2023-12-24',9 );
INSERT INTO dia_libre(codigo,dia,medico_codigo)  VALUES (3,'2023-12-25', 9);
INSERT INTO dia_libre (codigo,dia,medico_codigo) VALUES (4,'2023-11-15', 10);
INSERT INTO dia_libre (codigo,dia,medico_codigo) VALUES (5, '2023-10-10', 12);


insert into cita (codigo,estado_cita,fecha_cita,fecha_creacion,motivo,medico_codigo,paciente_codigo)
values (1,0, '2023-10-31 11:00:00', '2023-10-10 ', ' Cirugía General',8,4);
insert into cita (codigo,estado_cita,fecha_cita,fecha_creacion,motivo,medico_codigo,paciente_codigo)
values (2,0,'2023-12-27 14:00:00 ', '2023-11-20 ', 'Cirugía General',11 ,3);
insert into cita (codigo,estado_cita,fecha_cita,fecha_creacion,motivo,medico_codigo,paciente_codigo)
values (3,1,'2023-11-25 14:00:00', '2023-10-17 ', 'Ortopedia', 9,4);
insert into cita (codigo,estado_cita,fecha_cita,fecha_creacion,motivo,medico_codigo,paciente_codigo)
values (4,0,'2023-12-18 12:00:00', '2023-10-20 ', 'Cirugía General',8 ,6);
insert into cita (codigo,estado_cita,fecha_cita,fecha_creacion,motivo,medico_codigo,paciente_codigo)
values (5,2,'2023-12-25 10:00:00', '2023-10-30 ', 'neurología',12 ,6);



INSERT into atencion (codigo,asignacion_especialista,diagnostico,notas_medicas,tratamiento,cita_codigo,cita_asignada_codigo)
VALUES (1,false,'Gripe común', 'Reposo, tomar líquidos y paracetamol', 'Paciente debe descansar en casa durante 3 días',1 , 1);
INSERT into atencion (codigo,asignacion_especialista,diagnostico,notas_medicas,tratamiento,cita_codigo,cita_asignada_codigo)
VALUES (2,true, 'Esguince de tobillo', 'Inmovilización y fisioterapia', 'Se recomienda consultar a un especialista en ortopedia',2, 2);
INSERT into atencion (codigo,asignacion_especialista,diagnostico,notas_medicas,tratamiento,cita_codigo,cita_asignada_codigo)
VALUES (3, true, 'Fractura de muñeca', 'Cirugía y posterior rehabilitación', 'Inmovilizar la muñeca y seguir el plan de rehabilitación', 3, 3);
INSERT into atencion (codigo,asignacion_especialista,diagnostico,notas_medicas,tratamiento,cita_codigo,cita_asignada_codigo)
VALUES (4, false, 'Infección de garganta', 'Antibióticos y gárgaras con agua tibia y sal', 'Descanso vocal y evitar alimentos muy fríos o calientes', 4, 4);
INSERT into atencion (codigo,asignacion_especialista,diagnostico,notas_medicas,tratamiento,cita_codigo,cita_asignada_codigo)
VALUES (5,true,'Dolor de cabeza crónico', 'Analgesia y consulta con neurólogo', 'Consultar a un especialista en neurología para un diagnóstico más preciso',  5, 5);


INSERT INTO cambio_Cita (codigo,fecha,motivo,cita_codigo) VALUES (1,'2023-10-20 09:00:00', 'No pude asistir a tiempo a la cita',1);
INSERT INTO cambio_Cita (codigo,fecha,motivo,cita_codigo) VALUES (2,'2023-10-21 11:30:00', 'Los exámenes solicitados para la lectura, aún no se han realizado',1);
INSERT INTO cambio_Cita (codigo,fecha,motivo,cita_codigo) VALUES (3,'2023-12-30 13:15:00', 'Cambio de tipo de consulta ',2);
INSERT INTO cambio_Cita (codigo,fecha,motivo,cita_codigo)VALUES (4,'2023-12-23 10:00:00', 'No tengo disponibilidad para la fecha anterior',5);
INSERT INTO Cambio_Cita (codigo,fecha,motivo,cita_codigo) VALUES (5,'2023-12-15 11:30:00', 'Perdida de exámenes',4);


insert into pqrs (codigo, estadopqrs,fecha_creacion,motivo,tipopqrs,cita_codigo)
values (1,0,  '2023-10-05', 'El doctor fue grosero, no atendió correctamente ',1,2);
insert into pqrs (codigo, estadopqrs,fecha_creacion,motivo,tipopqrs,cita_codigo)
values (2,0,  '2023-12-01', 'Los exámenes enviados por el doctor son equivocados ',1,1);
insert into pqrs (codigo, estadopqrs,fecha_creacion,motivo,tipopqrs,cita_codigo)
values (3,1,  '2023-02-10', 'El doctor en la cita no me permitió hablar',1,5);
insert into pqrs (codigo, estadopqrs,fecha_creacion,motivo,tipopqrs,cita_codigo)
values (4,0, '2023-10-30', 'Solicitud de despacho de medicamentos en larga espera',0,4);
insert into pqrs (codigo, estadopqrs,fecha_creacion,motivo,tipopqrs,cita_codigo)
values (5,3 ,'2023-11-25', 'Solicitud, cambio de médico',0,1);


insert into mensaje (codigo,fecha_creacion,mensaje,cuenta_codigo,pqrs_codigo)
    value (1, '2023-10-11','Confirmo evidencias de la inconformidad recibida en la cita recibida ', 1, 1);
insert into mensaje(codigo,fecha_creacion,mensaje,cuenta_codigo,pqrs_codigo)
values (2, '2023-10-12','Por medio de este medio, daremos solucion a su inconformidad', 1, 1);
insert into mensaje (codigo,fecha_creacion,mensaje,cuenta_codigo,pqrs_codigo)
values (3, '2023-11-10','Negligencia en el momento de atencion de la cita', 2, 3);
insert into mensaje(codigo,fecha_creacion,mensaje,cuenta_codigo,pqrs_codigo)
values (4, '2023-11-01','Solicitud de envio de fechas para obtener los medicamentos, que son de urgencia', 1,4);
insert into mensaje(codigo,fecha_creacion,mensaje,cuenta_codigo,pqrs_codigo)
values (5, '2023-12-10','Solicitud cambio de medico por falta de tiempo para citas', 2, 5);