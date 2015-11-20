<div class="col-md-6">
	<!-- AREA CHART -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Birth report : BOY:GIRL - 2015</h3>
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
				<canvas id="barChart" height="250"></canvas>
			</div>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->

	<!-- DONUT CHART -->
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">Birth report : Average weight</h3>
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
			<canvas id="lineChart" height="250"></canvas>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Birth report : Delivery method - November</h3>
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
				<canvas id="dmChart" height="250"></canvas>
			</div>
		</div>
		<!-- /.box-body -->
	</div>

</div>
<!-- /.col (LEFT) -->
<div class="col-md-6">
	<!-- LINE CHART -->
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Birth report : Religion ratio</h3>
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
				<canvas id="pieChart" height="250"></canvas>
			</div>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->

	<!-- BAR CHART -->
	<div class="box box-success">
		<div class="box-header with-border">
			<h3 class="box-title">Birth report : Average weight</h3>
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
				<canvas id="areaChart" height="230"></canvas>
			</div>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Birth report : Delivery method - 2015</h3>
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
				<canvas id="dmYearChart" height="250"></canvas>
			</div>
		</div>
		<!-- /.box-body -->
	</div>

</div>
<!-- /.col (RIGHT) -->

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

		var avgPregnancyData = {
			labels : [ "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec" ],
			datasets : [ {
				label : "Birth report",
				fillColor : "rgba(60,141,188,0.9)",
				strokeColor : "rgba(60,141,188,0.8)",
				pointColor : "#4F98C3",
				pointStrokeColor : "rgba(60,141,188,1)",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(60,141,188,1)",
				data : [ 2.1, 2.3, 2.8, 3.0, 2.3, 1.8, 2.1, 1.9, 2.9, 3.1 ]
			} ]
		};

		var districtData = {
			labels : [ "ADB", "HYD", "KRN", "KHM", "MBN", "MDK", "NLG", "NZB",
					"RNR", "WRG" ],
			datasets : [
					{
						label : "AVG week with FORM F",
						fillColor : "rgba(210, 214, 222, 1)",
						strokeColor : "rgba(210, 214, 222, 1)",
						pointColor : "rgba(210, 214, 222, 1)",
						pointStrokeColor : "#c1c7d1",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(220,220,220,1)",
						data : [ 6900, 9900, 5000, 4100, 5600, 5500, 2000,
								7500, 4900, 8000 ]
					},
					{
						label : "AVG week with out FORM F",
						fillColor : "#FF69B4",
						strokeColor : "rgba(60,141,188,0.8)",
						pointColor : "#4F98C3",
						pointStrokeColor : "rgba(60,141,188,1)",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(60,141,188,1)",
						data : [ 6500, 9600, 4600, 3200, 5600, 5000, 2200,
								7100, 4850, 8200 ]
					} ]
		};

		var districtAvgWeightData = {
			labels : [ "ADB", "HYD", "KRN", "KHM", "MBN", "MDK", "NLG", "NZB",
					"RNR", "WRG" ],
			datasets : [ {
				label : "Birth report",
				fillColor : "rgba(60,141,188,0.9)",
				strokeColor : "rgba(60,141,188,0.8)",
				pointColor : "#4F98C3",
				pointStrokeColor : "rgba(60,141,188,1)",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(60,141,188,1)",
				data : [ 2.3, 1.8, 2.1, 1.9, 2.9, 3.1, 2.1, 2.3, 2.8, 3.0 ]
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
		areaChart.Line(avgPregnancyData, areaChartOptions);

		//-------------
		//- LINE CHART -
		//--------------
		var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
		var lineChart = new Chart(lineChartCanvas);
		var lineChartOptions = areaChartOptions;
		lineChartOptions.datasetFill = false;
		lineChart.Line(districtAvgWeightData, lineChartOptions);

		//-------------
		//- PIE CHART -
		//-------------
		// Get context with jQuery - using jQuery's .get() method.
		var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
		var pieChart = new Chart(pieChartCanvas);
		var PieData = [ {
			value : 1200000,
			color : "#f56954",
			highlight : "#f56954",
			label : "Hindu"
		}, {
			value : 700000,
			color : "#00a65a",
			highlight : "#00a65a",
			label : "Muslim"
		}, {
			value : 400000,
			color : "#f39c12",
			highlight : "#f39c12",
			label : "Christien"
		}, {
			value : 200000,
			color : "#00c0ef",
			highlight : "#00c0ef",
			label : "others"
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

		var dmChartCanvas = $("#dmChart").get(0).getContext("2d");
		var dmChart = new Chart(dmChartCanvas);
		var dmChartData = districtData;

		var barChartCanvas = $("#barChart").get(0).getContext("2d");
		var barChart = new Chart(barChartCanvas);
		var barChartData = districtData;

		barChartData.datasets[0].fillColor = "#0000FF";
		barChartData.datasets[0].strokeColor = "#0000FF";
		barChartData.datasets[0].pointColor = "#0000FF";

		barChartData.datasets[1].fillColor = "#FF69B4";
		barChartData.datasets[1].strokeColor = "#FF69B4";
		barChartData.datasets[1].pointColor = "#FF69B4";
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

		var dmDistData = {
			labels : [ "ADB", "HYD", "KRN", "KHM", "MBN", "MDK", "NLG", "NZB",
					"RNR", "WRG" ],
			datasets : [
					{
						label : "Natural",
						fillColor : "#006633",
						strokeColor : "#006633",
						pointColor : "#006633",
						pointStrokeColor : "#006633",
						pointHighlightFill : "#006633",
						pointHighlightStroke : "#006633",
						data : [ 900, 3800, 2000, 1000, 2600, 1700, 1500, 1800,
								1600, 900 ]
					},
					{
						label : "Caesarean",
						fillColor : "#A00000",
						strokeColor : "#A00000",
						pointColor : "#A00000",
						pointStrokeColor : "#A00000",
						pointHighlightFill : "#A00000",
						pointHighlightStroke : "#A00000",
						data : [ 6500, 9900, 5000, 4100, 5600, 5500, 2000,
								7500, 4900, 8000 ]
					},
					{
						label : "Forceps /Vacuum",
						fillColor : "#0000FF",
						strokeColor : "#0000FF",
						pointColor : "#0000FF",
						pointStrokeColor : "#0000FF",
						pointHighlightFill : "#0000FF",
						pointHighlightStroke : "#0000FF",
						data : [ 280, 880, 400, 190, 460, 270, 220, 380, 680,
								800 ]
					} ]
		};

		var dmChartCanvas = $("#dmChart").get(0).getContext("2d");
		var dmChart = new Chart(dmChartCanvas);
		var dmChartData = dmDistData;
		var dmChartOptions = {
			scaleBeginAtZero : true,
			scaleShowGridLines : true,
			scaleGridLineColor : "rgba(0,0,0,.05)",
			scaleGridLineWidth : 1,
			scaleShowHorizontalLines : true,
			scaleShowVerticalLines : true,
			barShowStroke : true,
			barStrokeWidth : 2,
			barValueSpacing : 5,
			barDatasetSpacing : 1,
			responsive : true,
			maintainAspectRatio : false
		};

		dmChartOptions.datasetFill = false;
		dmChart.Bar(dmChartData, dmChartOptions);

		var dmYearData = {
			labels : [ "2011", "2012", "2013", "2014", "2015" ],
			datasets : [ {
				label : "Natural",
				fillColor : "#006633",
				strokeColor : "#006633",
				pointColor : "#006633",
				pointStrokeColor : "#006633",
				pointHighlightFill : "#006633",
				pointHighlightStroke : "#006633",
				data : [ 100000, 260000, 170000, 150000, 190000 ]
			}, {
				label : "Caesarean",
				fillColor : "#A00000",
				strokeColor : "#A00000",
				pointColor : "#A00000",
				pointStrokeColor : "#A00000",
				pointHighlightFill : "#A00000",
				pointHighlightStroke : "#A00000",
				data : [ 500000, 410000, 560000, 550000, 1200000 ]
			}, {
				label : "Forceps /Vacuum",
				fillColor : "#0000FF",
				strokeColor : "#0000FF",
				pointColor : "#0000FF",
				pointStrokeColor : "#0000FF",
				pointHighlightFill : "#0000FF",
				pointHighlightStroke : "#0000FF",
				data : [ 88000, 40000, 19000, 68000, 180000 ]
			} ]
		};

		var dmYearChartCanvas = $("#dmYearChart").get(0).getContext("2d");
		var dmYearChart = new Chart(dmYearChartCanvas);
		var dmYearChartData = dmYearData;
		var dmYearChartOptions = {
			scaleBeginAtZero : true,
			scaleShowGridLines : true,
			scaleGridLineColor : "rgba(0,0,0,.05)",
			scaleGridLineWidth : 1,
			scaleShowHorizontalLines : true,
			scaleShowVerticalLines : true,
			barShowStroke : true,
			barStrokeWidth : 2,
			barValueSpacing : 5,
			barDatasetSpacing : 1,
			responsive : true,
			maintainAspectRatio : false
		};

		dmYearChartOptions.datasetFill = false;
		dmYearChart.Bar(dmYearChartData, dmYearChartOptions);
	});
</script>