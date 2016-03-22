$(document).ready(
		function() {
			limpiar();
			$('#formSeguimiento #tipo').children('option:not(:first-child)').remove();
			$('#formSeguimiento #categoria').children('option:not(:first-child)').remove();
			$('#formSeguimiento #subCategoria').children('option:not(:first-child)').remove();

			$('#formSeguimiento #tipo').change(function(event) {
				
				tipo = $('#formSeguimiento #tipo').val();
				if(tipo==2){
					$('#formSeguimiento #divLabelResExp').html("Residente");
					$('#formSeguimiento #residenteExpediente').attr("placeholder","Ingrese nombre del Residente").blur();
				} else if(tipo==1){
					$('#formSeguimiento #divLabelResExp').html("Expediente");
					$('#formSeguimiento #residenteExpediente').attr("placeholder","Ingrese nro del Expediente").blur();
				} else {
					$('#formSeguimiento #divLabelResExp').html("Residente / Expediente");
					$('#formSeguimiento #residenteExpediente').attr("Residente / Expediente").blur();
				}	
				
			});

			$.ajax({
				type : "GET",
				url : "listarTipo.htm",
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(response) {
					$('#formSeguimiento #tipo').children(
							'option:not(:first-child)').remove();
					$.each(response, function() {
						$('#formSeguimiento #tipo').append(
								'<option value=' + this.clave + '>'
										+ this.valor + '</option>');
					});
				}
			});
			
			$('#formSeguimiento #clickGuardar').click(function(event) {
				
				if(validaDatos()){
					$.ajax({
						type : "POST",
						url : "guardarOcurrencia.htm",
						data : $('#formSeguimiento').serialize(),
						success : function(response) {							
							if (response == '0') {
								window.location.href = 'direccionarLogin';
								alert("Su sesion ha expirado");
							} else if (response == '2') {
								alert("ocurrio un error")
							} else {
								var elemento = jQuery.parseJSON(response);
								if(elemento.codRespuesta==1) {
									limpiar();
								} else {
									alert("ocurrio un error")
								}															
							}
						}
					});
				}				
				
			});

			$('#formSeguimiento #clickLimpiar').click(function(event) {
				limpiar();				
			});
			
		});

function limpiar() {
	$('#formSeguimiento #residenteExpediente').val('');
	$('#formSeguimiento #fecha').val('');
	$('#formSeguimiento #hora').val('');
	$('#formSeguimiento #detalle').val('');
	$('#formSeguimiento #tipo').val('-1');
	$('#formSeguimiento #categoria').val('-1');
	$('#formSeguimiento #subCategoria').val('-1');
	$('#formSeguimiento #categoria').children('option:not(:first-child)').remove();
	$('#formSeguimiento #subCategoria').children('option:not(:first-child)').remove();

}

function validaDatos(){
	tipo = $('#formSeguimiento #tipo').val();	
	cat = $('#formSeguimiento #categoria').val();
	subCat = $('#formSeguimiento #subCategoria').val();
	resExp = $('#formSeguimiento #residenteExpediente').val();
	fecha = $('#formSeguimiento #fecha').val();
	hora = $('#formSeguimiento #hora').val();
	
	if(tipo=="-1" || cat=="-1" || subCat=="-1" || resExp == '' || fecha=='' || hora=='') {
		alert("Ingrese Datos");
		return false;
	}
	return true;
}

function mostrarCategoria() {
	var data = $('#formSeguimiento #tipo').val();
	
	if(data!=-1) {
		$.ajax({
			type : "GET",
			url : "listarCategoria.htm",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data : 'tipo=' + data,
			success : function(response) {							
				$('#formSeguimiento #categoria').children(
						'option:not(:first-child)').remove();
				$.each(response, function() {
					$('#formSeguimiento #categoria').append(
							'<option value=' + this.idcategoria + '>'
									+ this.ctgdescripcion + '</option>');
				});
			}
		});
	} else {
		$('#formSeguimiento #categoria').children('option:not(:first-child)').remove();
		$('#formSeguimiento #subCategoria').children('option:not(:first-child)').remove();
	}
}

function mostrarSubCategoria() {
	var data = $('#formSeguimiento #categoria').val();	
	if(data!=-1) {
		$.ajax({
			type : "GET",
			url : "listarSubCategoria.htm",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data : 'categoria=' + data,
			success : function(response) {
				$('#formSeguimiento #subCategoria').children(
						'option:not(:first-child)').remove();
				$.each(response, function() {
					$('#formSeguimiento #subCategoria').append(
							'<option value=' + this.idsubcategoria + '>'
									+ this.sctdescripcion + '</option>');
				});
			}
		});
	} else {
		$('#formSeguimiento #subCategoria').children('option:not(:first-child)').remove();
	}	
}