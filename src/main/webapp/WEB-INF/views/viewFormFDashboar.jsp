
<div class="col-md-6">
	<!-- DONUT CHART -->
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">FORM F - MTP Indication YES / NO -
				November</h3>
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
			<h3 class="box-title">FORM F - Pregnant with disorders - 2015</h3>
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
			<h3 class="box-title">FORM F - First child Female / Male - 2015</h3>
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
			<h3 class="box-title">FORM F - EDD by November</h3>
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

<script type="text/javascript">
$(function () {
  /* ChartJS
   * -------
   * Here we will create a few charts using ChartJS
   */

  // Get context with jQuery - using jQuery's .get() method.
  var areaChartCanvas = $("#formfdisorders").get(0).getContext("2d");
  // This will get the first returned node in the jQuery collection.
  var areaChart = new Chart(areaChartCanvas);

  var areaChartData = {
    labels: ["Jun","Jul", "Aug", "Sept", "Oct", "Nov", "Dec"],
    datasets: [
      {
        label: "Form F",
        fillColor: "rgba(210, 214, 222, 1)",
        strokeColor: "rgba(210, 214, 222, 1)",
        pointColor: "rgba(210, 214, 222, 1)",
        pointStrokeColor: "#c1c7d1",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "rgba(220,220,220,1)",
        data: [6500, 5900, 5600, 5500, 4000, 8000, 8100]
      },
      {
          label: "Disorders",
          fillColor: "rgba(40,101,138,0.8)",
          strokeColor: "rgba(50,121,168,0.8)",
          pointColor: "#2F6F94",
          pointStrokeColor: "rgba(50,131,168,2)",
          pointHighlightFill: "#fff",
          pointHighlightStroke: "rgba(60,141,188,1)",
          data: [1800, 2800, 3600, 2700, 1500,3000, 1400 ]
        }
    ]
  };
  
  
  var firstChildFemaleData = {
		    labels: ["2009","2010", "2011", "2012", "2013", "2014", "2015"],
		    datasets: [
		      {
		        label: "First child female",
		        fillColor: "rgba(210, 214, 222, 1)",
		        strokeColor: "rgba(210, 214, 222, 1)",
		        pointColor: "rgba(210, 214, 222, 1)",
		        pointStrokeColor: "#c1c7d1",
		        pointHighlightFill: "#fff",
		        pointHighlightStroke: "rgba(220,220,220,1)",
		        data: [750000, 590000, 800000, 810000, 560000, 550000, 600000]
		      },
		      {
		        label: "First child male",
		        fillColor: "rgba(60,141,188,0.9)",
		        strokeColor: "rgba(60,141,188,0.8)",
		        pointColor: "#4F98C3",
		        pointStrokeColor: "rgba(60,141,188,1)",
		        pointHighlightFill: "#fff",
		        pointHighlightStroke: "rgba(60,141,188,1)",
		        data: [380000, 280000, 400000, 600000, 190000, 270000, 550000]
		      }
		    ]
		  };
  
  var districtData = {
		    labels: ["ADB","HYD", "KRN", "KHM", "MBN", "MDK", "NLG","NZB","RNR","WRG"],
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
    //Boolean - If we should show the scale at all
    showScale: true,
    //Boolean - Whether grid lines are shown across the chart
    scaleShowGridLines: false,
    //String - Colour of the grid lines
    scaleGridLineColor: "rgba(0,0,0,.05)",
    //Number - Width of the grid lines
    scaleGridLineWidth: 1,
    //Boolean - Whether to show horizontal lines (except X axis)
    scaleShowHorizontalLines: true,
    //Boolean - Whether to show vertical lines (except Y axis)
    scaleShowVerticalLines: true,
    //Boolean - Whether the line is curved between points
    bezierCurve: true,
    //Number - Tension of the bezier curve between points
    bezierCurveTension: 0.3,
    //Boolean - Whether to show a dot for each point
    pointDot: false,
    //Number - Radius of each point dot in pixels
    pointDotRadius: 4,
    //Number - Pixel width of point dot stroke
    pointDotStrokeWidth: 1,
    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
    pointHitDetectionRadius: 20,
    //Boolean - Whether to show a stroke for datasets
    datasetStroke: true,
    //Number - Pixel width of dataset stroke
    datasetStrokeWidth: 2,
    //Boolean - Whether to fill the dataset with a color
    datasetFill: true,
    //String - A legend template
    //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
    maintainAspectRatio: false,
    //Boolean - whether to make the chart responsive to window resizing
    responsive: true
  };

  //Create the line chart
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
  // Get context with jQuery - using jQuery's .get() method.
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
    //Boolean - Whether we should show a stroke on each segment
    segmentShowStroke: true,
    //String - The colour of each segment stroke
    segmentStrokeColor: "#fff",
    //Number - The width of each segment stroke
    segmentStrokeWidth: 2,
    //Number - The percentage of the chart that we cut out of the middle
    percentageInnerCutout: 50, // This is 0 for Pie charts
    //Number - Amount of animation steps
    animationSteps: 100,
    //String - Animation easing effect
    animationEasing: "easeOutBounce",
    //Boolean - Whether we animate the rotation of the Doughnut
    animateRotate: true,
    //Boolean - Whether we animate scaling the Doughnut from the centre
    animateScale: false,
    //Boolean - whether to make the chart responsive to window resizing
    responsive: true,
    // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
    maintainAspectRatio: false,
    //String - A legend template
  };
  //Create pie or douhnut chart
  // You can switch between pie and douhnut using the method below.
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
    //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
    scaleBeginAtZero: true,
    //Boolean - Whether grid lines are shown across the chart
    scaleShowGridLines: true,
    //String - Colour of the grid lines
    scaleGridLineColor: "rgba(0,0,0,.05)",
    //Number - Width of the grid lines
    scaleGridLineWidth: 1,
    //Boolean - Whether to show horizontal lines (except X axis)
    scaleShowHorizontalLines: true,
    //Boolean - Whether to show vertical lines (except Y axis)
    scaleShowVerticalLines: true,
    //Boolean - If there is a stroke on each bar
    barShowStroke: true,
    //Number - Pixel width of the bar stroke
    barStrokeWidth: 2,
    //Number - Spacing between each of the X value sets
    barValueSpacing: 5,
    //Number - Spacing between data sets within X values
    barDatasetSpacing: 1,
    //String - A legend template
   
	
			//Boolean - whether to make the chart responsive
			responsive : true,
			maintainAspectRatio : false
		};

		barChartOptions.datasetFill = false;
		barChart.Bar(barChartData, barChartOptions);
	});
</script>