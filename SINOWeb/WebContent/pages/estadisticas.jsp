<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String rol = (String) session.getAttribute("rol");
	
%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

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
                <li><a href="seguimiento">Gestión Ocurrencias</a></li>
                <li class="active"><a href="estadisticas">Seguimiento</a></li>
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
      <a id="linkSesion" href="direccionarLogin"></a>      
      	<form:form id="formEstadistica" method="post" modelAttribute="estadistica" cssClass="form-horizontal">      
      	 <input type="hidden" id="idRolHidden" value="<%=rol%>">
          <fieldset>
            <legend>Validar ocurrencia</legend>
            <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                  <label for="fechaDesde" class="col-md-2 control-label">Fecha desde</label>
                  <div class="col-md-10">                  
                            <form:input id="fechaDesde" path="fechaDesde" type="date" cssClass="form-control" placeholder=""/>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="fechaHasta" class="col-md-2 control-label">Fecha hasta</label>
                  <div class="col-md-10">                  
                      <form:input id="fechaHasta" path="fechaHasta" type="date" cssClass="form-control" placeholder=""/>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="select111" class="col-md-2 control-label">Tipo</label>
                  <div class="col-md-10">
                  
                  		<form:select id="tipo" path="tipo" cssClass="form-control" onchange="javascript:mostrarCategoria();">
                  			<form:option value='0'>-Seleccione un tipo-</form:option>
    					</form:select>                  
                    
                  </div>
                </div>
              </div>
              
              <div class="col-md-6">
                <div class="form-group">
                  <label for="categoria" class="col-md-2 control-label">Categoría</label>
                  <div class="col-md-10">
                  
                  		<form:select path="categoria" cssClass="form-control" onchange="javascript:mostrarSubCategoria();">
                  			<form:option value='0'>-Seleccione una categoría-</form:option>
    					</form:select>     					
    					
                  </div>
                </div>
              </div> 
              
              <div class="col-md-6">
                <div class="form-group">
                  <label for="subcategoria" class="col-md-2 control-label">Sub-Categoría</label>
                  <div class="col-md-10">
                  
                  		<form:select path="subCategoria" cssClass="form-control">
                  			<form:option value='0'>-Seleccione una categoría-</form:option>
    					</form:select>
    					
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="buscar" class="col-md-2 control-label">Estado</label>
                  <div class="col-md-10">
                    <form:input id="descripcion" path="descripcion" style="display: none;" cssClass="form-control col-md-8" placeholder="Buscar ocurrencia"/>                    
                    <select id="estado" class="form-control">
                      <option value="">-Seleccione una estado-</option>
                      <option value="1">Nueva</option>
                      <option value="2">Validada</option>
                      <option value="3">No es ocurrencia</option>
                      <option value="4">En proceso</option>
                      <option value="5">Cerrada</option>
                      <option value="6">Suspendida</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <a href="javascript:void(0)" id="clickFiltrar" class="btn btn-raised btn-info">Filtrar <i class="material-icons">search</i></a>
              </div>
            </div>
          </fieldset>
        </form:form>
        <hr>
        <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel" id="gridSystemModal">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
            
            	<div id="divVerDetalle" style="display:none"><jsp:include page="verDetalleEstadistica.jsp" /></div>
            	<div id="divAtendida" style="display:none"><jsp:include page="atendida.jsp" /></div>
            	<div id="divSuspendida" style="display:none"><jsp:include page="suspendida.jsp" /></div>
            	<div id="divDetalleSeguimiento" style="display:none"><jsp:include page="detalleSeguimiento.jsp" /></div>
            	
              	   
              	           
            </div><!-- /.modal-content -->
          </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <div class="table-responsive">
        	<table id="tablaEstadistica" class="table table-striped table-hover ">
				<tr>
					<th>N°</th>
		              <th>Centro de atención</th>                         
		              <th>Fecha de ocurrencia</th>
		              <th>Hora de ocurrencia</th>
		              <th>Fecha de registro</th>
		              <th>Hora de registro</th>
		              <th>Tipo</th>
		              <th>Categoría</th>
		              <th>Sub Categoría</th>
		              <th>Estado</th>
		              <th>Ver</th>
				</tr>
			</table>
        	
          
        </div>
        

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
	<script src="js/app/estadistica.js" type="text/javascript"></script>
	
    <script>
      $(document).ready(function()
      {
        $('#fechaHasta').bootstrapMaterialDatePicker
        ({ 
          format : 'DD/MM/YYYY',
          weekStart : 0,
          time: false,
          clearButton: true,
          lang: 'es',
          nowText: 'Ahora',
          clearText: 'Limpiar',
          cancelText: 'Cancelar'
        });
        $('#fechaDesde').bootstrapMaterialDatePicker
        ({ 
          format : 'DD/MM/YYYY',
          weekStart : 0,
          time: false,
          clearButton: true,
          lang: 'es',
          nowText: 'Ahora',
          clearText: 'Limpiar',
          cancelText: 'Cancelar'
        }).on('change', function(e, date)
        {
        $('#fechaHasta').bootstrapMaterialDatePicker('setMinDate', date);
        });

        $.material.init();          
      });
    </script>
  </body>
</html>