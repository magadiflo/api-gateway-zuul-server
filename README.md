# API Gateway Zuul Server

## Importante
- Como estamos usando Zuul Server, es necesario que el proyecto de spring boot sea igual o inferior a la versión 2.3.12.RELEASE
ya que para versiones posteriores no funciona.  
Para versiones posteriores o actuales de Spring Boot se usa Spring Cloud Gateway (usa programación reactiva, etc..).  

Cambios a realizar para trabajar con Zuul

```
<version>2.3.12.RELEASE</version>
```

```
<spring-cloud.version>Hoxton.SR12</spring-cloud.version>
```

- Cuando ya se quiera **poner en funcionamiento Zuul Server**, es importante levantarlo al FINAL de TODOS LOS PROYECTOS

## Dependencias a usar:

- **Cliente de eureka:** Es importante que zuul o el api gateway sea un cliente de eureka,
porque a pesar de ser una puerta de enlace, un servidor que accede al resto de los
microservicios y los enruta, tiene que ser un servicio más de Eureka para poder
comunicarse con los demás.

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
- **Zuul server: ** Teniendo en cuenta la versión de Spring Boot comentado en el apartado superior.

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency>
```
