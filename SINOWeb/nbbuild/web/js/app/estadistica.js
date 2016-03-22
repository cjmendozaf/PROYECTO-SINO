$(document).ready(function() {
	
	$.ajax({
		type : "GET",
		url : "listarTipo.htm",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(response) {
			$('#formEstadistica #tipo').children(
					'option:not(:first-child)').remove();
			$.each(response, function() {
				$('#formEstadistica #tipo').append(
						'<option value=' + this.clave + '>'
								+ this.valor + '</option>');
			});
		}
	});
	
	$('#formEstadistica #clickFiltrar').click(function(event) {	
		$('#tablaEstadistica').find('tr:gt(0)').remove();
		buscar();
	});
	
	
	$('#btnValidarDetalle').click(function(event) {	
		codigo = $('#idHiddenDetalle').val();
		$.ajax({
			type : "POST",
			url : "validarEstadistica.htm",
			data : 'id=' + codigo,
			success : function(response) {
				if (response == '0') {
					window.location.href = 'direccionarLogin';
					alert("Su sesion ha expirado");
				} else if (response == '2') {
					alert("ocurrio un error")
				} else {
					var elemento = jQuery.parseJSON(response);
					if(elemento.codRespuesta==1) {
						$('#idHiddenBtnCerrarDetalle').click();
						buscar();
					} else {
						alert("ocurrio un error")
					}															
				}				
			}
		});
	});
	
	$('#btnEnviarNoCorrespondeDetalle').click(function(event) {	
		codigo = $('#idHiddenDetalle').val();
		detalle = $('#detalleNoCorrespondeDetalle').val();
		$.ajax({
			type : "POST",
			url : "noCorrespondeEnviarEstadistica.htm",
			data : 'id=' + codigo + '&detalle=' + detalle,
			success : function(response) {		
				if (response == '0') {
					window.location.href = 'direccionarLogin';
					alert("Su sesion ha expirado");
				} else if (response == '2') {
					alert("ocurrio un error")
				} else {
					var elemento = jQuery.parseJSON(response);
					if(elemento.codRespuesta==1) {
						$('#idHiddenBtnCerrarDetalle').click();
						buscar();
					} else {
						alert("ocurrio un error")
					}															
				}											
			}
		});
	});
	
	$('#btnNoCorrespondeDetalle').click(function(event) {	
		$('#detalleNoCorrespondeDetalle').val('');
		$('#divNoCorrespondeDetalle').show();
	});
	
	$('#btnLimpiarNoCorrespondeDetalle').click(function(event) {	
		$('#detalleNoCorrespondeDetalle').val('');
	});
	
	
	$('#btnCancelarNoCorrespondeDetalle').click(function(event) {	
		$('#divNoCorrespondeDetalle').hide();
	});
	
	
	// ATENDIDA
	$('#btnAtendido').click(function(event) {	
		codigo = $('#idHiddenAtendida').val();
		detalle = $('#detalleRegistrarAccionAtendida').val();
		$.ajax({
			type : "POST",
			url : "atendidoAtendidaEstadistica.htm",
			data : 'id=' + codigo + '&detalle=' + detalle,
			success : function(response) {		
				if (response == '0') {
					window.location.href = 'direccionarLogin';
					alert("Su sesion ha expirado");
				} else if (response == '2') {
					alert("ocurrio un error")
				} else {
					var elemento = jQuery.parseJSON(response);
					if(elemento.codRespuesta==1) {
						$('#idHiddenBtnCerrarAtendida').click();
						buscar();
					} else {
						alert("ocurrio un error")
					}															
				}												
			}
		});
	});
	$('#btnEnviarRegistrarAccionAtendida').click(function(event) {	
		codigo = $('#idHiddenAtendida').val();
		detalle = $('#detalleRegistrarAccionAtendida').val();
		$.ajax({
			type : "POST",
			url : "registrarAccionAtendidaEstadistica.htm",
			data : 'id=' + codigo + '&detalle=' + detalle,
			success : function(response) {		
				if (response == '0') {
					window.location.href = 'direccionarLogin';
					alert("Su sesion ha expirado");
				} else if (response == '2') {
					alert("ocurrio un error")
				} else {
					var elemento = jQuery.parseJSON(response);
					if(elemento.codRespuesta==1) {
						$('#idHiddenBtnCerrarAtendida').click();
						buscar();
					} else {
						alert("ocurrio un error")
					}															
				}												
			}
		});
	});
	
	$('#btnRegistrarAccionAtendida').click(function(event) {	
		$('#detalleRegistrarAccionAtendida').val('');
		$('#divRegistrarAccionDetalle').show();
	});
	
	$('#btnLimpiarRegistrarAccionAtendida').click(function(event) {	
		$('#detalleRegistrarAccionAtendida').val('');
	});
	
	
	$('#btnCancelarRegistrarAccionAtendida').click(function(event) {	
		$('#divRegistrarAccionDetalle').hide();
	});
	
	// SUSPENDIDA
	$('#btnCerrarOcurrenciaSuspendida').click(function(event) {	
		codigo = $('#idHiddenSuspendida').val();
		$.ajax({
			type : "POST",
			url : "cerrarOcurrenciaArgumentoSuspendidaEstadistica.htm",
			data : 'id=' + codigo,
			success : function(response) {
				if (response == '0') {
					window.location.href = 'direccionarLogin';
					alert("Su sesion ha expirado");
				} else if (response == '2') {
					alert("ocurrio un error")
				} else {
					var elemento = jQuery.parseJSON(response);
					if(elemento.codRespuesta==1) {
						$('#idHiddenBtnCerrarSuspendida').click();
						buscar();
					} else {
						alert("ocurrio un error")
					}															
				}
			}
		});
	});
	
	$('#btnDenegarSuspendida').click(function(event) {	
		$('#detalleDenegarSuspendida').val('');
		$('#divDenegarSuspendida').show();
	});
	
	$('#btnLimpiarDenegarSuspendida').click(function(event) {	
		$('#detalleDenegarSuspendida').val('');
	});
	
	$('#btnCancelarDenegarSuspendida').click(function(event) {	
		$('#divDenegarSuspendida').hide();
	});
	
	$('#btnEnviarDenegarSuspendida').click(function(event) {	
		codigo = $('#idHiddenSuspendida').val();
		detalle = $('#detalleDenegarSuspendida').val();
		$.ajax({
			type : "POST",
			url : "enviarDenegarSuspendidaEstadistica.htm",
			data : 'id=' + codigo + '&detalle=' + detalle,
			success : function(response) {	
				if (response == '0') {
					window.location.href = 'direccionarLogin';
					alert("Su sesion ha expirado");
				} else if (response == '2') {
					alert("ocurrio un error")
				} else {
					var elemento = jQuery.parseJSON(response);
					if(elemento.codRespuesta==1) {
						$('#idHiddenBtnCerrarSuspendida').click();
						buscar();
					} else {
						alert("ocurrio un error")
					}
				}
			}
		});
	});	
});

function buscar() {
	$.ajax({
		type : "POST",
		url : "buscarEstadistica.htm",
		data : $('#formEstadistica').serialize(),
		success : function(response) {
			$('#tablaEstadistica').find('tr:gt(0)').remove();
			var respuesta = jQuery.parseJSON(response);								
			var nro = 1;
			$.each(respuesta, function (key, element) {					
				adicionarFila(element, nro++);
			});				
		}
	});
}

function mostrarPopup(valor, estado, tipo, usu) {
	var rol = $('#idRolHidden').val();
	//alert(valor + " - " + estado + " - " + usu)
		
	if(tipo==2){ // INTERVENSION
		if(!usu && (estado==1 || estado==3) && (rol=2)){
	    	verValidar(valor);
		} else if(usu && (estado==2 || estado==5 || estado==7) && (rol==1 )){
			verAtender(valor);
		} else if(!usu && estado==4 && rol==2 ){ // consultar sobre el estado 7
			verCerrar(valor);
		} else {
			verDetalle(valor)
		}	
			/*else {
				$('#gridSystemModal').hide();
			}*/
		
	} else if(tipo==1) { //ADMINISTRATIVO
		
		if(!usu && (estado==1 || estado==3) && (rol=2)){
	    	verValidar(valor);
		} else if(!usu && (estado==2 || estado==5 || estado==7) && (rol==2 )){
			verAtender(valor);
		} else if(usu && estado==4 && rol==1 ){ // consultar sobre el estado 7
			verCerrar(valor);
		} else {
			verDetalle(valor)
		}	
		
	}
		
}

function verValidar(valor) {
	ocultarPopup();
	limpiar();
	$.ajax({
		type : "POST",
		url : "verDetalleEstadistica.htm",
		data : 'id=' + valor,
		success : function(response) {
			if (response == '0') {
				window.location.href = 'direccionarLogin';
				alert("Su sesion ha expirado");
			} else if(response=='2'){
				alert("ocurrio un error");
			} else {
				$('#gridSystemModal').modal();
				$('#divVerDetalle').show();
				var elemento = jQuery.parseJSON(response);
				$('#idHiddenDetalle').val(elemento.idocurrencia);
				$('#codigo').val(elemento.idocurrencia);
                                $('#detalle').val(elemento.ocudetalle);	
                                debugger;
				var date = elemento.ocufechaocurrencia;
				f1 = date.substring(0,4);
				f2 = date.substring(5,7);
				f3 = date.substring(8,10);
				f4 = date.substring(11,19);				
				$('#fecha').val(f3+"/"+f2+"/"+f1);
				$('#hora').val(f4);					
			}		
		}
	});
}

function verAtender(valor) {
	ocultarPopup();
	limpiar();
	$.ajax({
		type : "POST",
		url : "verDetalleEstadistica.htm",
		data : 'id=' + valor,
		success : function(response) {
			if (response == '0') {
				window.location.href = 'direccionarLogin';
				alert("Su sesion ha expirado");
			} else if(response=='2'){
				alert("ocurrio un error");
			} else {
				$('#gridSystemModal').modal();
				$('#divAtendida').show();
				var elemento = jQuery.parseJSON(response);
				$('#idHiddenAtendida').val(elemento.idocurrencia);
				$('#codigoAtendida').val(elemento.idocurrencia);				
				var date = elemento.ocufechaocurrencia;
				f1 = date.substring(0,4);
				f2 = date.substring(5,7);
				f3 = date.substring(8,10);
				f4 = date.substring(11,19);
				$('#fechaAtendida').val(f3+"/"+f2+"/"+f1);
				$('#horaAtendida').val(f4);
				$('#detalleAtendida').val(elemento.ocudetalle);			
			}		
		}
	});
}

function mostrarCategoria() {
	var data = $('#formEstadistica #tipo').val();
	
	if(data!=-1) {
		$.ajax({
			type : "GET",
			url : "listarCategoria.htm",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data : 'tipo=' + data,
			success : function(response) {							
				$('#formEstadistica #categoria').children(
						'option:not(:first-child)').remove();
				$.each(response, function() {
					$('#formEstadistica #categoria').append(
							'<option value=' + this.idcategoria + '>'
									+ this.ctgdescripcion + '</option>');
				});
			}
		});
	} else {
		$('#formEstadistica #categoria').children('option:not(:first-child)').remove();
		$('#formEstadistica #subCategoria').children('option:not(:first-child)').remove();
	}
}

function mostrarSubCategoria() {
	var data = $('#formEstadistica #categoria').val();	
	if(data!=-1) {
		$.ajax({
			type : "GET",
			url : "listarSubCategoria.htm",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data : 'categoria=' + data,
			success : function(response) {
				$('#formEstadistica #subCategoria').children(
						'option:not(:first-child)').remove();
				$.each(response, function() {
					$('#formEstadistica #subCategoria').append(
							'<option value=' + this.idsubcategoria + '>'
									+ this.sctdescripcion + '</option>');
				});
			}
		});
	} else {
		$('#formEstadistica #subCategoria').children('option:not(:first-child)').remove();
	}
	
}

function verCerrar(valor) {
	ocultarPopup();
	limpiar();
	$.ajax({
		type : "POST",
		url : "verDetalleEstadistica.htm",
		data : 'id=' + valor,
		success : function(response) {
			if (response == '0') {
				window.location.href = 'direccionarLogin';
				alert("Su sesion ha expirado");
			} else if(response=='2'){
				alert("ocurrio un error");
			} else {
				$('#gridSystemModal').modal();
				$('#divSuspendida').show();
				var elemento = jQuery.parseJSON(response);
				$('#idHiddenSuspendida').val(elemento.idocurrencia);
				$('#codigoSuspendida').val(elemento.idocurrencia);
				var date = elemento.ocufechaocurrencia
				f1 = date.substring(0,4);
				f2 = date.substring(5,7);
				f3 = date.substring(8,10);
				f4 = date.substring(11,19);	
				$('#fechaSuspendida').val(f3+"/"+f2+"/"+f1);
				$('#horaSuspendida').val(f4);
				$('#detalleSuspendida').val(elemento.ocudetalle);
				$('#ultimaAccionSuspendida').val("");// corregir
			}		
		}
	});
}

function verDetalle(valor) {
	ocultarPopup();
	limpiar();
	$.ajax({
		type : "POST",
		url : "verDetalleEstadistica.htm",
		data : 'id=' + valor,
		success : function(response) {
			if (response == '0') {
				window.location.href = 'direccionarLogin';
				alert("Su sesion ha expirado");
			} else if(response=='2'){
				alert("ocurrio un error");
			} else {
				$('#gridSystemModal').modal();
				$('#divDetalleSeguimiento').show();
				var elemento = jQuery.parseJSON(response);
				$('#idHiddenDetalleSeguimiento').val(elemento.idocurrencia);
				$('#codigoDetalleSeguimiento').val(elemento.idocurrencia);
				var date = elemento.ocufechaocurrencia
				f1 = date.substring(0,4);
				f2 = date.substring(5,7);
				f3 = date.substring(8,10);
				f4 = date.substring(11,19);	
				$('#fechaDetalleSeguimiento').val(f3+"/"+f2+"/"+f1);
				$('#horaDetalleSeguimiento').val(f4);
				$('#detalleDetalleSeguimiento').val(elemento.ocudetalle);
				$('#ultimaAccionDetalleSeguimiento').val("");
			}		
		}
	});
}

function adicionarFila(element, nro) {
	var fila;
	fila = '<tr>';
	fila += '<td>' + nro + '</td>';
	fila += '<td>' + element.centroAtencion + '</td>';
	fila += '<td>' + element.fechaOcurrencia + '</td>';
	fila += '<td>' + element.HoraOcurrencia + '</td>';
	fila += '<td>' + element.fechaRegistro + '</td>';
	fila += '<td>' + element.horaRegistro + '</td>';
	fila += '<td>' + element.tipo + '</td>';
	fila += '<td>' + element.categoria + '</td>';
	fila += '<td>' + element.subCategoria + '</td>';
	fila += '<td>' + element.estadoDescripcion + '</td>';
	fila += '<td><a href="javascript:mostrarPopup(' + element.id + ',' + element.estado + ',' + element.idTipo + ',' + element.usuarioRegistro + ')" class="btn btn-info"><i class="material-icons" >find_in_page</i></a></td>';
	fila += '</tr>';
	$('#tablaEstadistica').append(fila);
}

function ocultarPopup(){
	$('#gridSystemModal').hide();
	$('#divVerDetalle').hide();
	$('#divAtendida').hide();
	$('#divSuspendida').hide();
	$('#divDetalleSeguimiento').hide();
}

function limpiar() {
	$('#idHiddenDetalle').val('');
	$('#codigo').val('');
	$('#fecha').val('');
	$('#hora').val('');
	$('#detalle').val('');
	$('#detalleNoCorrespondeDetalle').val('');
	$('#detalleRegistrarAccionAtendida').val('');
	$('#detalleDenegarSuspendida').val('');
	$('#ultimaAccionSuspendida').val('');
	$('#divNoCorrespondeDetalle').hide();
	$('#divRegistrarAccionDetalle').hide();
	$('#divDenegarSuspendida').hide();
}