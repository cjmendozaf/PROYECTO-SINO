<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>PROYECTO SINO</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Material Design fonts -->
	  <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
	  <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/icon?family=Material+Icons">

	  <!-- Bootstrap -->
	  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

	  <!-- Bootstrap Material Design -->
	  <link rel="stylesheet" type="text/css" href="css/bootstrap-material-design.css">
	  <link rel="stylesheet" type="text/css" href="css/ripples.min.css">
          <link rel="stylesheet" type="text/css" href="css/sino-estilos.css">
  </head>
  <body>
    <div class="row">
      <div class="col-md-12">
        <div class="navbar navbar-inverse navbar-fixed-top">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="javascript:void(0)">Proyecto SINO</a>
            </div>
            <div class="navbar-collapse collapse navbar-inverse-collapse">
              <ul class="nav navbar-nav navbar-right">
                <li><a href="inicio">Inicio</a></li>
                <li class="active"><a href="seguimiento">Gestión Ocurrencias</a></li>
                <li><a href="estadisticas">Seguimiento</a></li>
                <li><a href="estadisticasrep">Estadisticas</a></li>
                <li><a href="javascript:void(0)">Mantenimiento tablas</a></li>
                <li><a href="javascript:void(0)">Cerrar sesión</a></li>            
              </ul>
            </div>
          </div>  
        </div>        
      </div>
    </div>
    
    <div class="container">
      <div class="well">
      <form:form id="formSeguimiento" method="post" modelAttribute="ocurrencia"> 
			
          <fieldset>
            <legend>Registro de ocurrencia</legend>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group">
                  <label for="select111" class="col-md-2 control-label">Tipo</label>
                  <div class="col-md-10">
                  
                  		<form:select id="tipo" path="tipo" cssClass="form-control" onchange="javascript:mostrarCategoria();">
                  			<form:option value='-1'>-Seleccione un tipo-</form:option>
    					</form:select>                  
                    
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                 
                  <label for="inputResExp" class="col-md-2 control-label" ><div id="divLabelResExp">Residente / Expediente</div></label>

                  <div class="col-md-10">
                    
                    <form:input id="residenteExpediente" path="residenteExpediente" cssClass="form-control" placeholder="Residente / Expediente"/>
                    
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="categoria" class="col-md-2 control-label">Categoría</label>
                  <div class="col-md-10">
                  
                  		<form:select path="categoria" cssClass="form-control" onchange="javascript:mostrarSubCategoria();">
                  			<form:option value='-1'>-Seleccione una categoría-</form:option>
    					</form:select>     					
    					
                  </div>
                </div>
              </div>              
              <div class="col-md-6">
                <div class="form-group">
                  <label for="subcategoria" class="col-md-2 control-label">Sub-Categoría</label>
                  <div class="col-md-10">
                  
                  		<form:select path="subCategoria" cssClass="form-control">
                  			<form:option value='-1'>-Seleccione una categoría-</form:option>
    					</form:select>
    					
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="fecha" class="col-md-2 control-label">Fecha ocurrencia</label>
                  <div class="col-md-10">      
                  	  <form:input id="fecha" path="fecha" type="date" cssClass="form-control" />
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="hora" class="col-md-2 control-label">Hora ocurrencia</label>
                  <div class="col-md-10">
                  	
                  	<form:input path="hora" type="time" cssClass="form-control" />
                  	                 
                  </div>
                </div>                
              </div>              
              <div class="col-md-6">
                <div class="form-group">
                  <label for="detalle" class="col-md-2 control-label">Detalle</label>
                  <div class="col-md-10">
                  
                  		<form:textarea id="detalle" path="detalle" rows="3" cssClass="form-control"/>
                  	
                    <span class="help-block">Escriba el detalle de la ocurrencia.</span>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="row">
                  <div class="col-sm-4">
                    <a href="javascript:void(0)" id="clickLimpiar" class="btn btn-raised btn-info">Limpiar <i class="material-icons">clear</i></a>
                  </div>
                  <div class="col-sm-4">
                    <a href="javascript:void(0)" id="clickGuardar" class="btn btn-raised btn-info">Guardar <i class="material-icons">archive</i></a>
                  </div>
                </div>
              </div>
            </div>
          </fieldset>
        </form:form>
      </div>      
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.12.0.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/material.min.js"></script>
    <script src="js/ripples.min.js"></script>
    <script type="text/javascript" src="http://momentjs.com/downloads/moment-with-locales.min.js"></script>
        
     <!-- jcuri -->
	<script src="js/app/seguimiento.js" type="text/javascript"></script>

    <script>
      $(document).ready(function()
      {
        $('#fecha').bootstrapMaterialDatePicker
        ({
          format : 'DD/MM/YYYY',
          time: false,
          clearButton: true,
          lang: 'es',
          nowText: 'Ahora',
          clearText: 'Limpiar',
          cancelText: 'Cancelar'
        });

        $('#hora').bootstrapMaterialDatePicker
        ({
          date: false,
          shortTime: true,
          format: 'HH:mm',
          cancelText: 'Cancelar'
        });

        $.material.init();
      });
    </script>
  </body>
</html>