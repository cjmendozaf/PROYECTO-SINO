<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
    <link rel="stylesheet" href="css/bootstrap-material-datetimepicker.css" />
    
    <!-- jcuri -->
	<script src="js/app/estadistica.js" type="text/javascript"></script>
	 
  </head>
  <body> 
   		 
   		 <input type="hidden" id="idHiddenBtnCerrarSuspendida" value="" data-dismiss="modal" aria-label="Close">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel">Datos de la ocurrencia</h4>
              </div>
              <hr>            
              	
              	<input type="hidden" id="idHiddenSuspendida" value="">
				<div class="modal-body">
                <div class="row">
                  <div class="col-md-6">
                    <div class="row">
                      <div class="col-xs-12">
                        <div class="form-group">
                          <label for="codigo" class="col-md-2 control-label">C�digo</label>
                          <div class="col-md-10">                  
                              <input type="text" id="codigoSuspendida" class="form-control" disabled="" value="${codigo}">
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12">
                        <div class="form-group">
                          <label for="fecha" class="col-md-2 control-label">Fecha</label>
                          <div class="col-md-10">                  
                              <input type="text" id="fechaSuspendida" class="form-control" disabled="" value="${fecha}">
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12">
                        <div class="form-group">
                          <label for="hora" class="col-md-2 control-label">Hora</label>
                          <div class="col-md-10">                  
                              <input type="text" id="horaSuspendida" class="form-control" disabled="" value="">
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="form-group">
                      <label for="detalle" class="col-md-2 control-label">Detalle</label>
                      <div class="col-md-10">                      
                        <textarea class="form-control" rows="3" id="detalleSuspendida" disabled=""></textarea>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="form-group">
                      <label for="detalle" class="col-md-2 control-label">Ultima Accion Registrada</label>
                      <div class="col-md-10">                      
                        <textarea class="form-control" rows="3" id="ultimaAccionSuspendida" disabled=""></textarea>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
			
              
              <hr>
              <div class="modal-footer">                
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                <button id="btnCerrarOcurrenciaSuspendida" type="button" class="btn btn-primary">Cerrar Ocurrencia</button>
                <button id="btnDenegarSuspendida" type="button" class="btn btn-primary">Denegar</button>
              </div>
                             
              <div id="divDenegarSuspendida" style="display:none">
              	  <hr>
	              <div class="row">
	              	<div class="col-md-6">
	              		<div class="row">
	              			<div class="col-xs-12">
	              				<textarea class="form-control" rows="2" id="detalleDenegarSuspendida"></textarea>
	              			</div>
	              		</div>              		
	              	</div>
	              </div>
	              <hr>
	              <div class="modal-footer">                
	                <button id="btnLimpiarDenegarSuspendida" type="button" class="btn btn-primary">Limpiar</button>
	                <button id="btnEnviarDenegarSuspendida" type="button" class="btn btn-primary">Enviar</button>
	                <button id="btnCancelarDenegarSuspendida" type="button" class="btn btn-primary">Cancelar</button>
	              </div>
              </div>            
              
            </div><!-- /.modal-content -->
          </div><!-- /.modal-dialog -->
</body>
</html>       
        