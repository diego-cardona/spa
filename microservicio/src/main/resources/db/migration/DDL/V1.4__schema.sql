create table if not exists cita (
   id int NOT NULL AUTO_INCREMENT,
   usuario int DEFAULT NULL,
   idProfesional int DEFAULT NULL,
   fecha datetime DEFAULT NULL,
   precio int DEFAULT NULL,
   serviciospa int DEFAULT NULL,
   KEY `usuario_idx` (`usuario`),
   KEY `serviciospa_idx` (`id`),
   KEY `serviciospa_idx1` (`serviciospa`),
   CONSTRAINT `serviciospa` FOREIGN KEY (`serviciospa`) REFERENCES `serviciospa` (`id`),
   CONSTRAINT `usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`)
);
