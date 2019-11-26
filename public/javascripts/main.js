function getCorrelationData(url, handleData){
    $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            contentType: "application/json",
            crossDomain: true,
//            async: false,
            success: function (data) {
//                console.log(data);
                handleData(data);
            }
     });
}
function plotData(xData, yData, title, xAxis, yAxis, chartType, chartId, seriesName, tooltip) {
    var chart = {
                   renderTo: 'chart',
      	           type: chartType,
      	           zoomType: 'x'
                };
                var title = {
                   text: title
                };
                var subtitle = {
                   text: 'Source: Kaggle.com'
                };
                //var g = data.genre.slice(1,-1).split(',');

                var tooltip = {
                   valueSuffix: tooltip
                };
                if(chartType == 'pie'){
                    var final = [];
                    for(var i=0; i < xData.length; i++) {
                        final.push({
                            name: xData[i],
                            y: yData[i]
                        });
                    }
                    var series = [
                                       {
                                         type: 'pie',
                                         colorByPoint: true,
                                         name: 'Rating',
                                         data: final
                                       }
                        ];
                }else{
                     var xAxis = {
                                       categories: xData,
                                       tickInterval:1,
                                       title: {
                                          text: xAxis,
                                          align: 'high'
                                       }
                                    };
                                    var yAxis = {
                                    min: 0,
                                       title: {
                                          text: yAxis,
                                          align: 'high'
                                       }
                                    };
                    var series = [
                                       {
                                          name: seriesName,
                                          data: yData
                                       }
                    ];
                }

                var json = {};
                json.chart = chart;
                json.title = title;
                json.subtitle = subtitle;
                json.tooltip = tooltip;
                json.xAxis = xAxis;
                json.yAxis = yAxis;
                json.series = series;
               $(chartId).highcharts(json);
}
if(document.getElementById("chart_1")){
    $(document).ready(function (){
        getCorrelationData("/api/1", function(output){
//            console.log(output)
            plotData(output.genre, output.maxBudget, 'Highest budget genre during 1986-2017','Genre', 'Max Budget (millions)','bar', '#chart_1', 'Budget', 'millions')
        });
        getCorrelationData("/api/2", function(output){
//            console.log(output)
            plotData(output.director, output.maxVotes, 'Highest votes received by director movie during 1986-2017','Director', 'MaxVotes (Thousands)','line', '#chart_2', 'Votes', 'K')
        });
        getCorrelationData("/api/3", function(output){
//                    console.log(output)
            plotData(output.runtime, output.votes, 'Runtime vs votes during 1986-2017','Runtime', 'Votes','line', '#chart_3', 'Votes', 'K')
        });
        getCorrelationData("/api/4", function(output){
//            console.log(output)
              plotData(output.name, output.score, 'Highest rated movie during 1986-2017','Movie', 'Score','line', '#chart_4', 'Score', '')
        });
        getCorrelationData("/api/5", function(output){
//                        console.log(output)
              plotData(output.genre, output.gross,' Highest revenue for each genre during 1986-2017','Genre', 'Revenue (millions)','bar', '#chart_5', 'Revenue', 'millions')
        });
        getCorrelationData("/api/6", function(output){
//                            console.log(output)
              plotData(output.company, output.gross,' Highest revenue for each company during 1986-2017','Company', 'Revenue (millions)','line', '#chart_6', 'Revenue', 'millions')
        });
        getCorrelationData("/api/7", function(output){
//                console.log(output)
              plotData(output.genre, output.score,' Highest rated genre during 1986-2017','Genre', 'Score','pie', '#chart_7', 'Score', '')
        });
        getCorrelationData("/api/8", function(output){
//            console.log(output)
            plotData(output.genre, output.movieCount, '# of movies by each genre during 1986-2017','Genre', 'No. of Movies','bar', '#chart_8', 'No. of Movies', '')
        });
    });
}
