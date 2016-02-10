<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"> 
	function printDashboardPage(){
		$('#offcanvas').click();
		$("#printButtonId").hide();
		javascript:window.print();
		$("#printButtonId").show();
	}
</script>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Dashboard <small>November</small>
	</h1>
	</section>
	
	<!-- Main content -->
	<section class="content"> <!-- Small boxes (Stat box) -->
	
	<div class="col-md-10 col-lg-10"></div>
	<div class="col-md-0 col-lg-0" id="printButtonId">
		<div class="form-group">
			<a class="btn btn-primary" href="#" onclick="printDashboardPage();">Print
				this page</a>
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-aqua">
				<div class="inner">
					<h3>15032</h3>
					<p>FORM F</p>
				</div>
				<div class="icon">
					<i class="fa fa-bed"></i>
				</div>
				<a href="#"
					onclick="submitForm('/account/formFDashboardDetails.action', 'NO-DATA', 'dashboardContainer');"
					class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>
		<%-- 
		<!-- ./col -->
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-yellow">
				<div class="inner">
					<h3>
						2923<sup style="font-size: 20px"></sup>
					</h3>
					<p>MTP</p>
				</div>
				<div class="icon">
					<i class="fa fa-scissors"></i>
				</div>
				<a href="#"
					onclick="submitForm('/account/mtpDashboardDetails.action', 'NO-DATA', 'dashboardContainer');"
					class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>
		<!-- ./col -->
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-green">
				<div class="inner">
					<h3>9305</h3>
					<p>Birth report</p>
				</div>
				<div class="icon">
					<i class="fa fa-child"></i>
				</div>
				<a href="#"
					onclick="submitForm('/account/birtReporthDashboardDetails.action', 'NO-DATA', 'dashboardContainer');"
					class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>
		<!-- ./col -->
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-red">
				<div class="inner">
					<h3>2804</h3>
					<p>Missing FORM Fs</p>
				</div>
				<div class="icon">
					<i class="ion ion-pie-graph"></i>
				</div>
				<a href="#"
					onclick="submitForm('/account/orphanFormFDashboardDetails.action', 'NO-DATA', 'dashboardContainer');"
					class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>
		<!-- ./col -->
		--%>
	</div>
	
	<!-- /.row --> <!-- Main row --> <section class="content">
	<div class="row" id="dashboardContainer">
		<div class="col-md-6">
			<!-- AREA CHART -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">2015 data</h3>
					<div class="box-tools pull-right">
						<button class="btn btn-box-tool" data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button class="btn btn-box-tool" data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<div class="box-body">
					<div class="chart">
						<canvas id="areaChart" height="250"></canvas>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

			<!-- DONUT CHART -->
			<div class="box box-danger">
				<div class="box-header with-border">
					<h3 class="box-title">2015 data</h3>
					<div class="box-tools pull-right">
						<button class="btn btn-box-tool" data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button class="btn btn-box-tool" data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<div class="box-body">
					<canvas id="pieChart" height="250"></canvas>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

		</div>
		<!-- /.col (LEFT) -->
		<div class="col-md-6">
			<!-- LINE CHART -->
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">Yearly data</h3>
					<div class="box-tools pull-right">
						<button class="btn btn-box-tool" data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button class="btn btn-box-tool" data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<div class="box-body">
					<div class="chart">
						<canvas id="lineChart" height="250"></canvas>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

			<!-- BAR CHART -->
			<div class="box box-success">
				<div class="box-header with-border">
					<h3 class="box-title">2015 data</h3>
					<div class="box-tools pull-right">
						<button class="btn btn-box-tool" data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button class="btn btn-box-tool" data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<div class="box-body">
					<div class="chart">
						<canvas id="barChart" height="230"></canvas>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

		</div>
		<!-- /.col (RIGHT) -->
	</div>
	<!-- /.row -->
</body>
<script type="text/javascript">
	$(function() {
		/* ChartJS
		 * -------
		 * Here we will create a few charts using ChartJS
		 */

		//--------------
		//- AREA CHART -
		//--------------
		// Get context with jQuery - using jQuery's .get() method.
		var areaChartCanvas = $("#areaChart").get(0).getContext("2d");
		// This will get the first returned node in the jQuery collection.
		var areaChart = new Chart(areaChartCanvas);

		var areaChartData = {
			labels : [ "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec" ],
			datasets : [ {
				label : "Form F",
				fillColor : "rgba(210, 214, 222, 1)",
				strokeColor : "rgba(210, 214, 222, 1)",
				pointColor : "rgba(210, 214, 222, 1)",
				pointStrokeColor : "#c1c7d1",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(220,220,220,1)",
				data : [ 6500, 5900, 8000, 8100, 5600, 5500, 2000 ]
			}, {
				label : "Birth report",
				fillColor : "rgba(60,141,188,0.9)",
				strokeColor : "rgba(60,141,188,0.8)",
				pointColor : "#4F98C3",
				pointStrokeColor : "rgba(60,141,188,1)",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(60,141,188,1)",
				data : [ 2800, 4800, 4000, 1900, 8600, 2700, 2200 ]
			}, {
				label : "MTP",
				fillColor : "rgba(40,101,138,0.8)",
				strokeColor : "rgba(50,121,168,0.8)",
				pointColor : "#2F6F94",
				pointStrokeColor : "rgba(50,131,168,2)",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(60,141,188,1)",
				data : [ 1800, 2800, 3000, 1400, 3600, 2700, 1500 ]
			} ]
		};

		var yearChartData = {
			labels : [ "2009", "2010", "2011", "2012", "2013", "2014", "2015" ],
			datasets : [
					{
						label : "Form F",
						fillColor : "rgba(210, 214, 222, 1)",
						strokeColor : "rgba(210, 214, 222, 1)",
						pointColor : "rgba(210, 214, 222, 1)",
						pointStrokeColor : "#c1c7d1",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(220,220,220,1)",
						data : [ 750000, 590000, 800000, 810000, 560000,
								550000, 600000 ]
					},
					{
						label : "Birth report",
						fillColor : "rgba(60,141,188,0.9)",
						strokeColor : "rgba(60,141,188,0.8)",
						pointColor : "#4F98C3",
						pointStrokeColor : "rgba(60,141,188,1)",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(60,141,188,1)",
						data : [ 380000, 280000, 400000, 600000, 190000,
								270000, 550000 ]
					},
					{
						label : "MTP",
						fillColor : "rgba(40,101,138,0.8)",
						strokeColor : "rgba(50,121,168,0.8)",
						pointColor : "#2F6F94",
						pointStrokeColor : "rgba(50,131,168,2)",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(60,141,188,1)",
						data : [ 180000, 280000, 400000, 140000, 160000,
								270000, 150000 ]
					} ]
		};

		var districtData = {
			labels : [ "ADB", "HYD", "KRN", "KHM", "MBN", "MDK", "NLG", "NZB",
					"RNR", "WRG" ],
			datasets : [
					{
						label : "Form F",
						fillColor : "rgba(210, 214, 222, 1)",
						strokeColor : "rgba(210, 214, 222, 1)",
						pointColor : "rgba(210, 214, 222, 1)",
						pointStrokeColor : "#c1c7d1",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(220,220,220,1)",
						data : [ 6500, 9900, 5000, 4100, 5600, 5500, 2000,
								7500, 4900, 8000 ]
					},
					{
						label : "Birth report",
						fillColor : "rgba(60,141,188,0.9)",
						strokeColor : "rgba(60,141,188,0.8)",
						pointColor : "#4F98C3",
						pointStrokeColor : "rgba(60,141,188,1)",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(60,141,188,1)",
						data : [ 2800, 8800, 4000, 1900, 4600, 2700, 2200,
								3800, 6800, 8000 ]
					},
					{
						label : "MTP",
						fillColor : "rgba(40,101,138,0.8)",
						strokeColor : "rgba(50,121,168,0.8)",
						pointColor : "#2F6F94",
						pointStrokeColor : "rgba(50,131,168,2)",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(60,141,188,1)",
						data : [ 1800, 5800, 3000, 1400, 3600, 2700, 1500,
								2800, 1800, 1000 ]
					} ]
		};

		var areaChartOptions = {
			//Boolean - If we should show the scale at all
			showScale : true,
			//Boolean - Whether grid lines are shown across the chart
			scaleShowGridLines : false,
			//String - Colour of the grid lines
			scaleGridLineColor : "rgba(0,0,0,.05)",
			//Number - Width of the grid lines
			scaleGridLineWidth : 1,
			//Boolean - Whether to show horizontal lines (except X axis)
			scaleShowHorizontalLines : true,
			//Boolean - Whether to show vertical lines (except Y axis)
			scaleShowVerticalLines : true,
			//Boolean - Whether the line is curved between points
			bezierCurve : true,
			//Number - Tension of the bezier curve between points
			bezierCurveTension : 0.3,
			//Boolean - Whether to show a dot for each point
			pointDot : false,
			//Number - Radius of each point dot in pixels
			pointDotRadius : 4,
			//Number - Pixel width of point dot stroke
			pointDotStrokeWidth : 1,
			//Number - amount extra to add to the radius to cater for hit detection outside the drawn point
			pointHitDetectionRadius : 20,
			//Boolean - Whether to show a stroke for datasets
			datasetStroke : true,
			//Number - Pixel width of dataset stroke
			datasetStrokeWidth : 2,
			//Boolean - Whether to fill the dataset with a color
			datasetFill : true,
			//String - A legend template
			//Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
			maintainAspectRatio : false,
			//Boolean - whether to make the chart responsive to window resizing
			responsive : true
		};

		//Create the line chart
		areaChart.Line(areaChartData, areaChartOptions);

		//-------------
		//- LINE CHART -
		//--------------
		var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
		var lineChart = new Chart(lineChartCanvas);
		var lineChartOptions = areaChartOptions;
		lineChartOptions.datasetFill = false;
		lineChart.Line(yearChartData, lineChartOptions);

		//-------------
		//- PIE CHART -
		//-------------
		// Get context with jQuery - using jQuery's .get() method.
		var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
		var pieChart = new Chart(pieChartCanvas);
		var PieData = [ {
			value : 1300000,
			color : "#f56954",
			highlight : "#f56954",
			label : "Form F"
		}, {
			value : 800000,
			color : "#00a65a",
			highlight : "#00a65a",
			label : "Birth report"
		}, {
			value : 400000,
			color : "#f39c12",
			highlight : "#f39c12",
			label : "MTP"
		}, {
			value : 100000,
			color : "#00c0ef",
			highlight : "#00c0ef",
			label : "Missing"
		}, ];
		var pieOptions = {
			//Boolean - Whether we should show a stroke on each segment
			segmentShowStroke : true,
			//String - The colour of each segment stroke
			segmentStrokeColor : "#fff",
			//Number - The width of each segment stroke
			segmentStrokeWidth : 2,
			//Number - The percentage of the chart that we cut out of the middle
			percentageInnerCutout : 50, // This is 0 for Pie charts
			//Number - Amount of animation steps
			animationSteps : 100,
			//String - Animation easing effect
			animationEasing : "easeOutBounce",
			//Boolean - Whether we animate the rotation of the Doughnut
			animateRotate : true,
			//Boolean - Whether we animate scaling the Doughnut from the centre
			animateScale : false,
			//Boolean - whether to make the chart responsive to window resizing
			responsive : true,
			// Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
			maintainAspectRatio : false,
		//String - A legend template
		};
		//Create pie or douhnut chart
		// You can switch between pie and douhnut using the method below.
		pieChart.Doughnut(PieData, pieOptions);

		//-------------
		//- BAR CHART -
		//-------------
		var barChartCanvas = $("#barChart").get(0).getContext("2d");
		var barChart = new Chart(barChartCanvas);
		var barChartData = districtData;
		barChartData.datasets[1].fillColor = "#00a65a";
		barChartData.datasets[1].strokeColor = "#00a65a";
		barChartData.datasets[1].pointColor = "#00a65a";
		var barChartOptions = {
			//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
			scaleBeginAtZero : true,
			//Boolean - Whether grid lines are shown across the chart
			scaleShowGridLines : true,
			//String - Colour of the grid lines
			scaleGridLineColor : "rgba(0,0,0,.05)",
			//Number - Width of the grid lines
			scaleGridLineWidth : 1,
			//Boolean - Whether to show horizontal lines (except X axis)
			scaleShowHorizontalLines : true,
			//Boolean - Whether to show vertical lines (except Y axis)
			scaleShowVerticalLines : true,
			//Boolean - If there is a stroke on each bar
			barShowStroke : true,
			//Number - Pixel width of the bar stroke
			barStrokeWidth : 2,
			//Number - Spacing between each of the X value sets
			barValueSpacing : 5,
			//Number - Spacing between data sets within X values
			barDatasetSpacing : 1,
			//String - A legend template

			//Boolean - whether to make the chart responsive
			responsive : true,
			maintainAspectRatio : false
		};

		barChartOptions.datasetFill = false;
		barChart.Bar(barChartData, barChartOptions);
	});
</script>
</html>