<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    let chart03 = {
        init: function(){
            this.getdata1();
            this.getdata2();
            this.getdata3();
            this.getdata4();
        },
        getdata1: function(){
            $.ajax({
                url: '/chart0301',
                success: function(result){
                    chart03.display1(result);
                }
            });
        },
        getdata2: function(){
            $.ajax({
                url:'/chart0302',
                success: function(result){
                    chart03.display2(result);
                }
            });
        },
        getdata3: function(){
            $.ajax({
                url:'/chart0303',
                success: function(result){
                    chart03.display3(result);
                }
            });
        },
        getdata4: function() {
            $.ajax({
                url: '/chart0304',
                success: function (result) {
                    chart03.display4(result);
                }
            })
        },
        display1: function(result){
            Highcharts.chart('c1', {
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 45
                    }
                },
                title: {
                    text: 'Beijing 2022 gold medals by country',
                    align: 'left'
                },
                subtitle: {
                    text: '3D donut in Highcharts',
                    align: 'left'
                },
                plotOptions: {
                    pie: {
                        innerSize: 100,
                        depth: 45
                    }
                },
                series: [{
                    name: 'Medals',
                    data:result
                }]
            });
        },
        display2: function(result){
            var chart = Highcharts.chart('c2', {

                chart: {
                    type: 'column'
                },

                title: {
                    text: 'Born persons, by girls\' name'
                },

                subtitle: {
                    text: 'Resize the frame or click buttons to change appearance'
                },

                legend: {
                    align: 'right',
                    verticalAlign: 'middle',
                    layout: 'vertical'
                },

                xAxis: {
                    categories: result.category,
                    labels: {
                        x: -10
                    }
                },

                yAxis: {
                    allowDecimals: false,
                    title: {
                        text: 'Amount'
                    }
                },

                series: [{
                    name: 'sunmi',
                    data: result.datas
                }, {
                    name: 'jinhee',
                    data: result.datas2
                }, {
                    name: 'seongyoung',
                    data: result.datas3
                }],

                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                align: 'center',
                                verticalAlign: 'bottom',
                                layout: 'horizontal'
                            },
                            yAxis: {
                                labels: {
                                    align: 'left',
                                    x: 0,
                                    y: -5
                                },
                                title: {
                                    text: null
                                }
                            },
                            subtitle: {
                                text: null
                            },
                            credits: {
                                enabled: false
                            }
                        }
                    }]
                }
            });
            //
            // document.getElementById('small').addEventListener('click', function () {
            //     chart.setSize(400);
            // });
            //
            // document.getElementById('large').addEventListener('click', function () {
            //     chart.setSize(600);
            // });
            //
            // document.getElementById('auto').addEventListener('click', function () {
            //     chart.setSize(null);
            // });
        },
        display3: function(result){
            Highcharts.chart('c3', {
                chart: {
                    type: 'area',
                    options3d: {
                        enabled: true,
                        alpha: 15,
                        beta: 30,
                        depth: 200
                    }
                },
                title: {
                    text: 'Visual comparison of Mountains Panorama'
                },
                accessibility: {
                    description: 'The chart is showing the shapes of three mountain ranges as three area line series laid out in 3D behind each other.',
                    keyboardNavigation: {
                        seriesNavigation: {
                            mode: 'serialize'
                        }
                    }
                },
                lang: {
                    accessibility: {
                        axis: {
                            xAxisDescriptionPlural: 'The chart has 3 unlabelled X axes, one for each series.'
                        }
                    }
                },
                yAxis: {
                    title: {
                        text: 'Height Above Sea Level',
                        x: -40
                    },
                    labels: {
                        format: '{value:,.0f} MAMSL'
                    },
                    gridLineDashStyle: 'Dash'
                },
                xAxis: [{
                    visible: false
                }, {
                    visible: false
                }, {
                    visible: false
                }],
                plotOptions: {
                    area: {
                        depth: 100,
                        marker: {
                            enabled: false
                        },
                        states: {
                            inactive: {
                                enabled: false
                            }
                        }
                    }
                },
                tooltip: {
                    valueSuffix: ' MAMSL'
                },
                series: [{
                    name: 'Tatra Mountains visible from Rusinowa polana',
                    lineColor: 'rgb(180,90,50)',
                    color: 'rgb(200,110,50)',
                    fillColor: 'rgb(200,110,50)',
                    data: result.a
                }, {
                    xAxis: 1,
                    lineColor: 'rgb(120,160,180)',
                    color: 'rgb(140,180,200)',
                    fillColor: 'rgb(140,180,200)',
                    name: 'Dachstein panorama seen from Krippenstein',
                    data: result.b
                }, {
                    xAxis: 2,
                    lineColor: 'rgb(200, 190, 140)',
                    color: 'rgb(200, 190, 140)',
                    fillColor: 'rgb(230, 220, 180)',
                    name: 'Panorama from Col Des Mines',
                    data: result.c
                }]
            });

        },
        display4: function(result){
            Highcharts.chart('c4', {
                chart: {
                    type: 'funnel3d',
                    options3d: {
                        enabled: true,
                        alpha: 10,
                        depth: 50,
                        viewDistance: 50
                    }
                },
                title: {
                    text: 'Highcharts Funnel3D Chart'
                },
                accessibility: {
                    screenReaderSection: {
                        beforeChartFormat: '<{headingTagName}>{chartTitle}</{headingTagName}><div>{typeDescription}</div><div>{chartSubtitle}</div><div>{chartLongdesc}</div>'
                    }
                },
                plotOptions: {
                    series: {
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b> ({point.y:,.0f})',
                            allowOverlap: true,
                            y: 10
                        },
                        neckWidth: '30%',
                        neckHeight: '25%',
                        width: '80%',
                        height: '80%'
                    }
                },
                series: [{
                    name: 'Unique users',
                    data:result
                }]
            });
        }
    };
    $(function(){
        chart03.init();
    })

</script>

<div class="col-sm-8 text-left">
    <div >
        <h3>CHART03</h3>
        <div class="row">
            <div id = "c1" class="col-sm-4"></div>
            <div id = "c2" class="col-sm-4"></div>
            <div id = "c3" class="col-sm-4"></div>
        </div>
        <div class="row">
            <div id = "c4" class="col-sm-4"></div>
            <div id = "c5" class="col-sm-4"></div>
            <div id = "c6" class="col-sm-4"></div>
        </div>
    </div>
</div>
