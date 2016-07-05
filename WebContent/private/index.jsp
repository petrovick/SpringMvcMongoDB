<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
		<script src="https://code.highcharts.com/highcharts.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
		
	</head>
	<body>
		<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		<br />
		
		<div id="containerCalculado" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		
		<script>
			$(function () {

				debugger;
				var energias = $.parseJSON('${registros}');

				var sizeArray = energias.length;

				var minhaSerieCalculado = [];
				
				var categorias = [];
				var minhaSerie = [];
				$.each(energias, function( index, value ) {
					var dataSplited = value.dataHora.split("-");
					categorias.push(dataSplited[2].substring(0, 2) + '/' + dataSplited[1] + ' ' + dataSplited[2].substring(3, 8));
					minhaSerie.push(value.kws);
					
					if(index == 0)
					{
						minhaSerieCalculado.push(0);
					}
					else
					{
						minhaSerieCalculado.push(value.kws - energias[index - 1].kws);
					}
					
				});

			    $('#container').highcharts({
			        chart: {
			            type: 'line'
			        },
			        title: {
			            text: 'Consumo de energia diário'
			        },
			        subtitle: {
			            text: 'Fonte: Gabriel Petrovick'
			        },
			        xAxis: {
			            categories: categorias//['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
			        },
			        yAxis: {
			            title: {
			                text: 'Kilowatts (KWS)'
			            }
			        },
			        plotOptions: {
			            line: {
			                dataLabels: {
			                    enabled: true
			                },
			                enableMouseTracking: false
			            }
			        },
			        series: [{
			            name: 'Francisco Faria, 500 - Patos de Minas',
			            data: minhaSerie//[7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
			        }]
			    });
			    
				//Calculado
			    $('#containerCalculado').highcharts({
			        chart: {
			            type: 'column'
			        },
			        title: {
			            text: 'Diferença de consumo por registro'
			        },
			        subtitle: {
			            text: 'Fonte: Gabriel Petrovick'
			        },
			        xAxis: {
			            categories: categorias//['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
			        },
			        yAxis: {
			            title: {
			                text: 'Kilowatts (KWS)'
			            }
			        },
			        plotOptions: {
			            line: {
			                dataLabels: {
			                    enabled: true
			                },
			                enableMouseTracking: false
			            }
			        },
			        series: [{
			            name: 'Francisco Faria, 500 - Patos de Minas',
			            data: minhaSerieCalculado//[7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
			        }]
			    });
			});
		</script>
		
		
		
		
	</body>
</html>