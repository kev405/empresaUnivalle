CREATE TABLE usuario(
 id integer NOT NULL, 
 nombre  varchar(100) NOT NULL, 
 direccion varchar(1255) NOT NULL, 
 PRIMARY KEY (id)
);

CREATE TABLE vendedor(
 id integer NOT NULL, 
 nombre  varchar(100) NOT NULL, 
 direccion varchar(1255) NOT NULL, 
 cantidad_Productos integer NOT NULL,
 numero_Venta integer NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE proveedor(
 id integer NOT NULL, 
 nombre  varchar(100) NOT NULL, 
 direccion varchar(1255) NOT NULL, 
 nombre_Insumo varchar(155) NOT NULL,
 numero_Venta integer NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE cliente(
 id integer NOT NULL, 
 nombre  varchar(100) NOT NULL, 
 direccion varchar(1255) NOT NULL, 
 edad integer NOT NULL,
 cantidadPedido integer NOT NULL,
 tipoPago varchar(155) NOT NULL,
 PRIMARY KEY (id)
);


