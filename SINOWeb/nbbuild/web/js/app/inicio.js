$(document).ready(function() {
	
	$.ajax({
		type : "POST",
		url : "datosGrafico.htm",
		data : 'id=1',
		success : function(response) {
			var elemento = jQuery.parseJSON(response);			
			var array = elemento.data.split(',');
			
			var chart1 = new AwesomeChart('chartCanvas1');
            chart1.title = "Ocurrencias Intervención: 7 dias";
            chart1.data = array;
            chart1.labels = ['Nuevas','En proceso','Atendida','Cerradas','Suspendidas'];
            chart1.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart1.randomColors = true;
            chart1.animate = true;
            chart1.animationFrames = 30;
            chart1.draw();
		}
	});
	
/*	$.ajax({
		type : "POST",
		url : "datosGrafico.htm",
		data : 'id=2',
		success : function(response) {
			alert("eee")
			var elemento = jQuery.parseJSON(response);			
			var array = elemento.data.split(',');
			
			alert(array)
			var data = new Array();
			for (var i=0; i<array.length; i++) {				
				data[i]=array[i];
			}
			alert(data)
			 var chart2 = new AwesomeChart('chartCanvas2');
	            chart2.chartType = "pie";
	            chart2.title = "Ocurrencias Intervención: 7 días";
	            chart2.data = data;
	            chart2.labels = ['Nuevas','En proceso','Atendida','Cerradas','Suspendidas'];
	            chart2.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
	            chart2.animate = true;
	            chart2.draw();
		}
	});
*/
	$.ajax({
		type : "POST",
		url : "datosGrafico.htm",
		data : 'id=3',
		success : function(response) {
			var elemento = jQuery.parseJSON(response);			
			var array = elemento.data.split(',');
			
			var chart3 = new AwesomeChart('chartCanvas3');
            chart3.title = "Ocurrencias Administrativas: 7 dias";
            chart3.data = array;
            chart3.labels = ['Nuevas','En proceso','Atendida','Cerradas','Suspendidas'];
            chart3.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart3.randomColors = true;
            chart3.animate = true;
            chart3.animationFrames = 30;
            chart3.draw();
		}
	});
	
/*	$.ajax({
		type : "POST",
		url : "datosGrafico.htm",
		data : 'id=4',
		success : function(response) {
			var elemento = jQuery.parseJSON(response);			
			var array = elemento.data.split(',');
			var data;
			for (var i=0; i<array.length; i++) {
				data[i]=array[i];
			}
			alert(data)
			var chart4 = new AwesomeChart('chartCanvas4');
            chart4.chartType = "pie";
            chart4.title = "Ocurrencias Administrativas: 7 dias";
            chart4.data = data;
            chart4.labels = ['Nuevas','En proceso','Atendida','Cerradas','Suspendidas'];
            chart4.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart4.animate = true;
            chart4.draw();
		}
	});
	*/
});