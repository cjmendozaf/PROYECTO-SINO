<!DOCTYPE html>
<html>
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
                <li class="active"><a href="inicio">Inicio</a></li>
                <li><a href="seguimiento">Gestión Ocurrencias</a></li>
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
      <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel" id="ocuCritica">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel"><img src="../img/rojo.png" /> Ocurrencias criticas</h4>
              </div>
              <hr>
              <div class="modal-body">
                <table class="table table-striped table-hover ">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Centro</th>
                        <th>Tipo</th>
                        <th>Categoria</th>
                        <th>Sub-Categoria</th>
                        <th>Ver</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>Centro 1</td>
                        <td>Tipo 1</td>
                        <td>Categoria 1</td>
                        <td>Sub-cat 1</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>2</td>
                        <td>Centro 2</td>
                        <td>Tipo 2</td>
                        <td>Categoria 2</td>
                        <td>Sub-cat 2</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>3</td>
                        <td>Centro 3</td>
                        <td>Tipo 3</td>
                        <td>Categoria 3</td>
                        <td>Sub-cat 3</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>                 
                    </tbody>
                  </table>
              </div>
              <hr>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>                
              </div>
            </div><!-- /.modal-content -->
          </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
      <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel" id="ocuMediana">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel"><img src="../img/amarillo.png" /> Ocurrencias mediadas</h4>
              </div>
              <hr>
              <div class="modal-body">
                <table class="table table-striped table-hover ">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Centro</th>
                        <th>Tipo</th>
                        <th>Categoria</th>
                        <th>Sub-Categoria</th>
                        <th>Ver</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>Centro 1</td>
                        <td>Tipo 1</td>
                        <td>Categoria 1</td>
                        <td>Sub-cat 1</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>2</td>
                        <td>Centro 1</td>
                        <td>Tipo 1</td>
                        <td>Categoria 3</td>
                        <td>Sub-cat 1</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>3</td>
                        <td>Centro 3</td>
                        <td>Tipo 3</td>
                        <td>Categoria 3</td>
                        <td>Sub-cat 3</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>4</td>
                        <td>Centro 4</td>
                        <td>Tipo 4</td>
                        <td>Categoria 4</td>
                        <td>Sub-cat 4</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>                 
                    </tbody>
                  </table>
              </div>
              <hr>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>                
              </div>
            </div><!-- /.modal-content -->
          </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
      <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel" id="ocuBaja">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel"><img src="../img/verde.png" /> Ocurrencias bajas</h4>
              </div>
              <hr>
              <div class="modal-body">
                <table class="table table-striped table-hover ">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Centro</th>
                        <th>Tipo</th>
                        <th>Categoria</th>
                        <th>Sub-Categoria</th>
                        <th style="text-align: center;">Ver</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>Centro 1</td>
                        <td>Tipo 1</td>
                        <td>Categoria 1</td>
                        <td>Sub-cat 1</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>2</td>
                        <td>Centro 1</td>
                        <td>Tipo 1</td>
                        <td>Categoria 3</td>
                        <td>Sub-cat 1</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>1</td>
                        <td>Centro 1</td>
                        <td>Tipo 1</td>
                        <td>Categoria 1</td>
                        <td>Sub-cat 1</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>1</td>
                        <td>Centro 1</td>
                        <td>Tipo 1</td>
                        <td>Categoria 1</td>
                        <td>Sub-cat 1</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>1</td>
                        <td>Centro 1</td>
                        <td>Tipo 1</td>
                        <td>Categoria 1</td>
                        <td>Sub-cat 1</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>1</td>
                        <td>Centro 1</td>
                        <td>Tipo 1</td>
                        <td>Categoria 1</td>
                        <td>Sub-cat 1</td>
                        <td><a href="seguimiento"><i class="material-icons">pageview</i></a></td>
                      </tr>                 
                    </tbody>
                  </table>
              </div>
              <hr>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>                
              </div>
            </div><!-- /.modal-content -->
          </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
      <div class="row">
        <div class="col-sm-12">          
          <div class="row">
            <div class="col-md-12 col-lg-6">
              <div class="panel panel-info">
                <div class="panel-heading">
                  <h3 class="panel-title">Resumen de alertas</h3>
                </div>
                <div class="panel-body">
                  <table class="table table-striped table-hover ">
                    <thead>
                      <tr>
                        <th>Alerta</th>
                        <th>Estado</th>
                        <th>Cantidad</th>
                        <th>Ver</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td><img src="../img/rojo.png" /></td>   
                        <td>Criticas</td>
                        <td>3</td>
                        <td><a href="#" class="btn btn-info" data-toggle="modal" data-target="#ocuCritica"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                          <td><img src="../img/amarillo.png" /></td>   
                        <td>Medianas</td>
                        <td>4</td>
                        <td><a href="#" class="btn btn-info" data-toggle="modal" data-target="#ocuMediana"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td><img src="../img/verde.png" /></td>   
                        <td>Bajas</td>
                        <td>5</td>
                        <td><a href="#" class="btn btn-info" data-toggle="modal" data-target="#ocuBaja"><i class="material-icons">pageview</i></a></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <div class="col-md-6 col-lg-3">
              <div class="panel panel-info">
                <div class="panel-heading">
                  <h3 class="panel-title">Ocurrencias de intervención</h3>
                </div>
                <div class="panel-body">
                  <table class="table table-striped table-hover ">
                    <thead>
                      <tr>
                        <th>Ocurrencias</th>
                        <th>Cantidad</th>
                        <th>Ver</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>Nuevas</td>
                        <td>1</td>
                        <td><a href="#"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>En proceso</td>
                        <td>2</td>
                        <td><a href="#"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>Atendida</td>
                        <td>3</td>
                        <td><a href="#"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>Cerradas</td>
                        <td>4</td>
                        <td><a href="#"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>Suspendidas</td>
                        <td>5</td>
                        <td><a href="#"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr class="info">
                        <td>Total</td>
                        <td>21</td>
                        <td></td>
                      </tr>                  
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <div class="col-md-6 col-lg-3">
              <div class="panel panel-info">
                <div class="panel-heading">
                  <h3 class="panel-title">Ocurrencias administrativas</h3>
                </div>
                <div class="panel-body">
                  <table class="table table-striped table-hover ">
                    <thead>
                      <tr>
                        <th>Ocurrencias</th>
                        <th>Cantidad</th>
                        <th>Ver</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>Nuevas</td>
                        <td>1</td>
                        <td><a href="#"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>En proceso</td>
                        <td>2</td>
                        <td><a href="#"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>Atendida</td>
                        <td>3</td>
                        <td><a href="#"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>Cerradas</td>
                        <td>4</td>
                        <td><a href="#"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr>
                        <td>Suspendidas</td>
                        <td>5</td>
                        <td><a href="#"><i class="material-icons">pageview</i></a></td>
                      </tr>
                      <tr class="info">
                        <td>Total</td>
                        <td>21</td>
                        <td></td>
                      </tr>                  
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>  
        </div>
        <div class="col-sm-12">
          <div class="row">            
            <div class="col-sm-12 col-md-6 col-lg-6">
              <canvas id="chartCanvas1" width="400" height="400">
                    Ocurrencias Intervención: 7 días
              </canvas>
            </div>
            <div class="col-sm-12 col-md-6 col-lg-6">
              <canvas id="chartCanvas2" width="400" height="400">
                    Ocurrencias Intervención: 7 días
              </canvas>
            </div>
              <br>   
            <div class="col-sm-12 col-md-6 col-lg-6">
              <canvas id="chartCanvas3" width="400" height="400">
                    Ocurrencias Administrativas: 7 días
              </canvas>
            </div>
            <div class="col-sm-12 col-md-6 col-lg-6">
              <canvas id="chartCanvas4" width="400" height="400">
                    Ocurrencias Administrativas: 7 días
              </canvas>
            </div>
          </div>
        </div>
      </div>      
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.12.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/material.min.js"></script>
    <script src="js/ripples.min.js"></script>
    <script src="js/awesomechart.js"></script>
    <!--<script src="js/app/inicio.js" type="text/javascript"></script>-->
    <script type="application/javascript">            
            var chart1 = new AwesomeChart('chartCanvas1');
            chart1.title = "Ocurrencias Intervención: 7 días";
            chart1.data = [30,25,20,15,10];
            chart1.labels = ['Nuevas','En proceso','Atendida','Cerradas','Suspendidas'];
            chart1.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart1.randomColors = true;
            chart1.animate = true;
            chart1.animationFrames = 30;
            chart1.draw();

            var chart2 = new AwesomeChart('chartCanvas2');
            chart2.chartType = "pie";
            chart2.title = "Ocurrencias Intervención: 7 días";
            chart2.data = [10,20,10,10,20];
            chart2.labels = ['Nuevas','En proceso','Atendida','Cerradas','Suspendidas'];
            chart2.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart2.animate = true;
            chart2.draw();
         
            var chart3 = new AwesomeChart('chartCanvas3');
            chart3.title = "Ocurrencias Administrativas: 7 días";
            chart3.data = [30,25,20,15,10];
            chart3.labels = ['Nuevas','En proceso','Atendida','Cerradas','Suspendidas'];
            chart3.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart3.randomColors = true;
            chart3.animate = true;
            chart3.animationFrames = 30;
            chart3.draw();

            var chart4 = new AwesomeChart('chartCanvas4');
            chart4.chartType = "pie";
            chart4.title = "Ocurrencias Administrativas: 7 días";
            chart4.data = [30,25,20,15,10];
            chart4.labels = ['Nuevas','En proceso','Atendida','Cerradas','Suspendidas'];
            chart4.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart4.animate = true;
            chart4.draw();
            
        </script>
    <script>
      $(function () {
        $.material.init();
      })
    </script>
  </body>
</html>