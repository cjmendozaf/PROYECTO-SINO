<%-- 
    Document   : estadisticasrep
    Created on : 17/03/2016, 09:31:38 AM
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <li><a href="estadisticas">Seguimiento</a></li>
                <li class="active"><a href="estadisticasrep">Estadisticas</a></li>
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
            <legend>Reportes estadisticos</legend>
            <div class="row">            
              <div class="col-md-6">
                <div class="form-group">
                  <label for="fechaDesde" class="col-md-2 control-label">Fecha desde</label>
                  <div class="col-md-10">                  
                      <input id="fechaDesde" type="date" class="form-control" placeholder="">
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="fechaHasta" class="col-md-2 control-label">Fecha hasta</label>
                  <div class="col-md-10">                  
                      <input id="fechaHasta" type="date" class="form-control" placeholder="">
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="buscar" class="col-md-2 control-label">Linea</label>
                  <div class="col-md-10">                    
                    <select id="estado" class="form-control">
                      <option value="">-Seleccione una linea-</option>
                      <option value="1">USPNA</option>
                      <option value="2">UDF</option>
                      <option value="3">USPPD</option>
                      <option value="4">USPPAM</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <a href="javascript:void(0)" id="clickFiltrar" class="btn btn-raised btn-info">Filtrar <i class="material-icons">search</i></a>
              </div>
            </div>
          <hr>                            
      </div>         
          <div class="row">            
            <div class="col-sm-12 col-md-6 col-lg-6">
              <canvas id="chartCanvas1" width="400" height="400">
                    Ocurrencias Intervención
              </canvas>
            </div>
            <div class="col-sm-12 col-md-6 col-lg-6">
              <canvas id="chartCanvas2" width="400" height="400">
                    Ocurrencias Intervención
              </canvas>
            </div>
              <br>   
            <div class="col-sm-12 col-md-6 col-lg-6">
              <canvas id="chartCanvas3" width="400" height="400">
                    Ocurrencias Administrativas
              </canvas>
            </div>
            <div class="col-sm-12 col-md-6 col-lg-6">
              <canvas id="chartCanvas4" width="400" height="400">
                    Ocurrencias Administrativas
              </canvas>
            </div>
            <div class="col-sm-12 col-md-6 col-lg-6">
              <canvas id="chartCanvas5" width="400" height="400">
                    General de Intervención
              </canvas>
            </div>
            <div class="col-sm-12 col-md-6 col-lg-6">
              <canvas id="chartCanvas6" width="400" height="400">
                    General de Administrativas
              </canvas>
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
    <script src="js/awesomechart.js"></script>
    
    <script type="application/javascript">            

     
            var chart1 = new AwesomeChart('chartCanvas1');
            chart1.title = "Ocurrencias Intervención";
            chart1.data = [50,35,24,18,10];
            chart1.labels = ['Nuevas','En proceso','Atendida','Cerradas','Suspendidas'];
            chart1.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart1.randomColors = true;
            chart1.animate = true;
            chart1.animationFrames = 30;
            chart1.draw();

            var chart2 = new AwesomeChart('chartCanvas2');
            chart2.chartType = "pie";
            chart2.title = "Ocurrencias Intervención";
            chart2.data = [50,25,13,8,4];
            chart2.labels = ['Salud','Integridad','Salida no autorizada','Servicio de seguridad','Fenomenos naturales'];
            chart2.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart2.animate = true;
            chart2.draw();
         
            var chart3 = new AwesomeChart('chartCanvas3');
            chart3.title = "Ocurrencias Administrativas";
            chart3.data = [35,25,22,13,5];
            chart3.labels = ['Nuevas','En proceso','Atendida','Cerradas','Suspendidas'];
            chart3.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart3.randomColors = true;
            chart3.animate = true;
            chart3.animationFrames = 30;
            chart3.draw();

            var chart4 = new AwesomeChart('chartCanvas4');
            chart4.chartType = "pie";
            chart4.title = "Ocurrencias Administrativas";
            chart4.data = [35,25,25,15,5];
            chart4.labels = ['Equipamiento','Financiera','Saneamiento','Infraestructura','RRHH'];
            chart4.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart4.animate = true;
            chart4.draw();
            
            var chart5 = new AwesomeChart('chartCanvas5');
            chart5.title = "General de Intervención";
            chart5.data = [45,25,20,10];
            chart5.labels = ['USPNNA','UDF','USPPD','USPPAM'];
            chart5.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart5.randomColors = true;
            chart5.animate = true;
            chart5.animationFrames = 30;
            chart5.draw();

            var chart6 = new AwesomeChart('chartCanvas6');            
            chart6.title = "General de Administrativas";
            chart6.data = [50,20,18,12];
            chart6.labels = ['UDF','USPPAM','USPNNA','UDF'];
            chart6.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart6.randomColors = true;
            chart6.animate = true;
            chart6.animationFrames = 30;
            chart6.draw();
            
        </script>

    <script>
      $(document).ready(function()
      {      

        $.material.init();          
      });
    </script>
  </body>
</html>
