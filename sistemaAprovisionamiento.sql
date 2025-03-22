-- Crear la base de datos
CREATE DATABASE sistemaAprovisionamiento;
USE sistemaAprovisionamiento;

-- Crear las secuencias
CREATE TABLE secuencias (
    nombre VARCHAR(50) PRIMARY KEY,
    valor INT NOT NULL
);

INSERT INTO secuencias (nombre, valor) VALUES
('idOperacion', 0),
('idCifras', 0),
('idDetalle', 0),
('idIncidencias', 0),
('idBitacora', 0),
('idConstancia', 0),
('folio', 0);

DELIMITER //
CREATE PROCEDURE nextval(nombre VARCHAR(50), OUT nuevo_valor INT)
BEGIN
    UPDATE secuencias 
    SET valor = valor + 1 
    WHERE nombre = nombre 
    LIMIT 1; -- Ensure only one row is updated

    SELECT valor 
    INTO nuevo_valor 
    FROM secuencias 
    WHERE nombre = nombre 
    LIMIT 1; -- Ensure only one row is selected
END //
DELIMITER ;

-- Procedimiento para generar el siguiente valor de folio
DELIMITER //
CREATE PROCEDURE next_folio(OUT nuevo_folio VARCHAR(50))
BEGIN
    DECLARE nuevo_valor INT;
    CALL nextval('folio', nuevo_valor);
    SET nuevo_folio = CONCAT('FOL-', LPAD(nuevo_valor, 10, '0'));
END //
DELIMITER ;

-- Crear la tabla de cifras
CREATE TABLE cifras (
    idCifras INT PRIMARY KEY,
    idOperacion INT,
    incidencias INT,
    totalRecibidos INT,
    totalNOK INT,
    totalOK INT,
    usr VARCHAR(50),
    fechaCreacion DATETIME
);

-- Crear la tabla de notificaciones
CREATE TABLE notificaciones (
    idOperacion INT PRIMARY KEY,
    nombreArchivo VARCHAR(255),
    fechaAlta DATETIME,
    usr VARCHAR(50),
    tipoOperacion VARCHAR(50),
    idCifras INT,
    idDetalle INT,
    idIncidencias INT,
    fechaCreacion DATETIME,
    estatus VARCHAR(50),
    FOREIGN KEY (idCifras) REFERENCES cifras(idCifras)
);

-- Crear la tabla de detalle
CREATE TABLE detalle (
    idDetalle INT PRIMARY KEY,
    idOperacion INT,
    idCifras INT,
    cliente VARCHAR(255),
    cuenta VARCHAR(50),
    folio VARCHAR(50) UNIQUE,
    rfcR VARCHAR(13),
    rfcE VARCHAR(13),
    tipoParticipacion VARCHAR(50),
    ejercicioFiscal INT,
    estatus VARCHAR(50),
    idConstancia INT,
    version VARCHAR(10),
    fechaCreacion DATETIME,
    fechaCancelacion DATETIME,
    FOREIGN KEY (idOperacion) REFERENCES notificaciones(idOperacion),
    FOREIGN KEY (idCifras) REFERENCES cifras(idCifras)
);

-- Crear la tabla de incidencias
CREATE TABLE incidencias (
    idIncidencias INT PRIMARY KEY,
    idOperacion INT,
    fechaCreacion DATETIME,
    folio VARCHAR(50),
    cuenta VARCHAR(50),
    cliente VARCHAR(255),
    rfcE VARCHAR(13),
    rfcR VARCHAR(13),
    idCifras INT,
    codError VARCHAR(50),
    descripcionError TEXT,
    FOREIGN KEY (idOperacion) REFERENCES notificaciones(idOperacion),
    FOREIGN KEY (idCifras) REFERENCES cifras(idCifras)
);

-- Crear la tabla de bitacora
CREATE TABLE bitacora (
    idBitacora INT PRIMARY KEY,
    idOperacion INT,
    idIncidencias INT,
    idCifras INT,
    idDetalle INT,
    folio VARCHAR(50),
    cuenta VARCHAR(50),
    cliente VARCHAR(255),
    fechaCreacion DATETIME,
    estatus VARCHAR(50),
    version VARCHAR(10),
    FOREIGN KEY (idOperacion) REFERENCES notificaciones(idOperacion),
    FOREIGN KEY (idIncidencias) REFERENCES incidencias(idIncidencias),
    FOREIGN KEY (idCifras) REFERENCES cifras(idCifras),
    FOREIGN KEY (idDetalle) REFERENCES detalle(idDetalle)
);

-- Crear índices
CREATE INDEX idx_notificaciones_idCifras ON notificaciones(idCifras);
CREATE INDEX idx_notificaciones_idDetalle ON notificaciones(idDetalle);
CREATE INDEX idx_notificaciones_idIncidencias ON notificaciones(idIncidencias);

CREATE INDEX idx_detalle_idOperacion ON detalle(idOperacion);
CREATE INDEX idx_detalle_idCifras ON detalle(idCifras);
CREATE INDEX idx_detalle_folio ON detalle(folio);
CREATE INDEX idx_detalle_cliente ON detalle(cliente);
CREATE INDEX idx_detalle_cuenta ON detalle(cuenta);

CREATE INDEX idx_cifras_idOperacion ON cifras(idOperacion);

CREATE INDEX idx_incidencias_idOperacion ON incidencias(idOperacion);
CREATE INDEX idx_incidencias_idCifras ON incidencias(idCifras);

CREATE INDEX idx_bitacora_idOperacion ON bitacora(idOperacion);
CREATE INDEX idx_bitacora_idIncidencias ON bitacora(idIncidencias);
CREATE INDEX idx_bitacora_idCifras ON bitacora(idCifras);
CREATE INDEX idx_bitacora_idDetalle ON bitacora(idDetalle);
