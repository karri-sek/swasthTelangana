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
		Dashboard <small>February</small>
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
					<h3>${formFTotal}</h3>
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
	</div>

	<!-- /.row --> <!-- Main row --> <section class="content">
	<div class="row" id="dashboardContainer">

		<div class="col-md-6">
			<!-- DONUT CHART -->
			<div class="box box-danger">
				<div class="box-header with-border">
					<h3 class="box-title">FORM F - MTP Indication YES / NO</h3>
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
					<canvas id="mtpindication" height="250"></canvas>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

			<!-- AREA CHART -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">FORM F - Pregnant with disorders</h3>
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
						<canvas id="formfdisorders" height="250"></canvas>
					</div>
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
					<h3 class="box-title">FORM F - First child Female / Male</h3>
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
						<canvas id="FirstChildFemale" height="250"></canvas>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

			<!-- BAR CHART -->
			<div class="box box-success">
				<div class="box-header with-border">
					<h3 class="box-title">FORM F - EDD by February </h3>
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
						<canvas id="eddChart" height="230"></canvas>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

		</div>
		<!-- /.col (RIGHT) -->
		</div>
</body>

<script type="text/javascript">
$(function () {
  var areaChartCanvas = $("#formfdisorders").get(0).getContext("2d");
  var areaChart = new Chart(areaChartCanvas);
  var jsonResults = JSON.parse('${results}');
  
  var areaChartData = {
    labels: jsonResults.districtLabel,
    datasets: [
      {
        label: "Form F",
        fillColor: "rgba(210, 214, 222, 1)",
        strokeColor: "rgba(210, 214, 222, 1)",
        pointColor: "rgba(210, 214, 222, 1)",
        pointStrokeColor: "#c1c7d1",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "rgba(220,220,220,1)",
        data: jsonResults.pregnantDisorderYes//[6500, 5900, 5600, 5500, 4000, 8000, 8100, 5900, 5600, 5500]
      },
      {
          label: "Disorders",
          fillColor: "rgba(40,101,138,0.8)",
          strokeColor: "rgba(50,121,168,0.8)",
          pointColor: "#2F6F94",
          pointStrokeColor: "rgba(50,131,168,2)",
          pointHighlightFill: "#fff",
          pointHighlightStroke: "rgba(60,141,188,1)",
          data: jsonResults.pregnantDisorderNo//[1800, 2800, 3600, 2700, 1500,3000, 1400, 5200, 3600, 4500 ]
        }
    ]
  };
  
  
  var firstChildFemaleData = {
		    //labels: ["2009","2010", "2011", "2012", "2013", "2014", "2015"],
		    labels: jsonResults.districtLabel,
		    
		    datasets: [
		      {
		        label: "First child female",
		        fillColor: "rgba(210, 214, 222, 1)",
		        strokeColor: "rgba(210, 214, 222, 1)",
		        pointColor: "rgba(210, 214, 222, 1)",
		        pointStrokeColor: "#c1c7d1",
		        pointHighlightFill: "#fff",
		        pointHighlightStroke: "rgba(220,220,220,1)",
		        data: jsonResults.firstChildfemaleYes //[750000, 590000, 800000, 810000, 560000, 550000, 600000, 100000, 500000, 900000]
		      },
		      {
		        label: "First child male",
		        fillColor: "rgba(60,141,188,0.9)",
		        strokeColor: "rgba(60,141,188,0.8)",
		        pointColor: "#4F98C3",
		        pointStrokeColor: "rgba(60,141,188,1)",
		        pointHighlightFill: "#fff",
		        pointHighlightStroke: "rgba(60,141,188,1)",
		        data: jsonResults.firstChildfemaleNo //[380000, 280000, 400000, 600000, 190000, 270000, 550000, 100000, 900000, 100000]
		      }
		    ]
		  };
  
  //debugger;
  //EDD details
  var districtData = {
		  	labels: jsonResults.districtLabel,
		    datasets: [
		      {
		        label: "Form F",
		        fillColor: "rgba(210, 214, 222, 1)",
		        strokeColor: "rgba(210, 214, 222, 1)",
		        pointColor: "rgba(210, 214, 222, 1)",
		        pointStrokeColor: "#c1c7d1",
		        pointHighlightFill: "#fff",
		        pointHighlightStroke: "rgba(220,220,220,1)",
		        data: [6500, 9900, 5000, 4100, 5600, 5500, 2000, 7500, 4900, 8000]
		      },
		      {
		        label: "Birth report",
		        fillColor: "rgba(60,141,188,0.9)",
		        strokeColor: "rgba(60,141,188,0.8)",
		        pointColor: "#4F98C3",
		        pointStrokeColor: "rgba(60,141,188,1)",
		        pointHighlightFill: "#fff",
		        pointHighlightStroke: "rgba(60,141,188,1)",
		        data: [1800, 6800, 4000, 1900, 1600, 2700, 2200, 2800, 1800, 3000]
		      }
		    ]
		  };

  var areaChartOptions = {
    showScale: true,
    scaleShowGridLines: false,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: true,
    bezierCurve: true,
    bezierCurveTension: 0.3,
    pointDot: false,
    pointDotRadius: 4,
    pointDotStrokeWidth: 1,
    pointHitDetectionRadius: 20,
    datasetStroke: true,
    datasetStrokeWidth: 2,
    datasetFill: true,
    maintainAspectRatio: false,
    responsive: true
  };

  areaChart.Line(areaChartData, areaChartOptions);

  //-------------
  //- LINE CHART -
  //--------------
  var lineChartCanvas = $("#FirstChildFemale").get(0).getContext("2d");
  var lineChart = new Chart(lineChartCanvas);
  var lineChartOptions = areaChartOptions;
  lineChartOptions.datasetFill = false;
  lineChart.Line(firstChildFemaleData, lineChartOptions);

  //-------------
  //- PIE CHART -
  //-------------
  var pieChartCanvas = $("#mtpindication").get(0).getContext("2d");
  var pieChart = new Chart(pieChartCanvas);
  var PieData = [
    {
      value: 130000,
      color: "#f56954",
      highlight: "#f56954",
      label: "MTP Indication - NO"
    },
    {
      value: 800000,
      color: "#00a65a",
      highlight: "#00a65a",
      label: "MTP Indication - YES"
    }
  ];
  var pieOptions = {
    segmentShowStroke: true,
    segmentStrokeColor: "#fff",
    segmentStrokeWidth: 2,
    percentageInnerCutout: 50, // This is 0 for Pie charts
    animationSteps: 100,
    animationEasing: "easeOutBounce",
    animateRotate: true,
    animateScale: false,
    responsive: true,
    maintainAspectRatio: false,
  };
  
  pieChart.Doughnut(PieData, pieOptions);

  //-------------
  //- BAR CHART -
  //-------------
  var barChartCanvas = $("#eddChart").get(0).getContext("2d");
  var barChart = new Chart(barChartCanvas);
  var barChartData = districtData;
  barChartData.datasets[1].fillColor = "#00a65a";
  barChartData.datasets[1].strokeColor = "#00a65a";
  barChartData.datasets[1].pointColor = "#00a65a";
  var barChartOptions = {
    scaleBeginAtZero: true,
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: true,
    barShowStroke: true,
    barStrokeWidth: 2,
    barValueSpacing: 5,
    barDatasetSpacing: 1,
			responsive : true,
			maintainAspectRatio : false
		};

		barChartOptions.datasetFill = false;
		barChart.Bar(barChartData, barChartOptions);
	});
</script>
</html>