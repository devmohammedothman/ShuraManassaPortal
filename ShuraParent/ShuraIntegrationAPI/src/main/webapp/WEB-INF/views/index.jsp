<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="generalHTML">
<head>

<title>������ ����������� ����� ������ �������</title>
<base href="/">
<meta charset="utf-8">
<meta name="description"
	content="Material design admin template with pre-built apps and pages">
<meta name="keywords"
	content="HTML,CSS,AngularJS,Angular,Angular 2,Angular 4,Angular 5,Angular 6,Material">
<meta name="author" content="Withinpixels">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<link rel="icon" type="image/x-icon" href="favicon.ico">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="ShuraIntegrationAPI/resources/assets/icons/meteocons/style.css" rel="stylesheet">
<!-- <link href="https://fonts.googleapis.com/css?family=Cairo:300,400,500" rel="stylesheet"> -->
<link rel="stylesheet" media="screen"
	href="https://fontlibrary.org/face/droid-arabic-kufi" type="text/css" />

<!-- FUSE Splash Screen CSS -->
<style type="text/css">
#fuse-splash-screen {
	display: block;
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	z-index: 99999;
	pointer-events: none;
}

#fuse-splash-screen::before {
	content: '';
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	background-image: url('ShuraIntegrationAPI/resources/assets/images/backgrounds/patterm.png');
	background-color: #033C4A;
}

#fuse-splash-screen .center {
	display: block;
	width: 100%;
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
}

#fuse-splash-screen .logo {
	width: 128px;
	margin: 0 auto;
}

#fuse-splash-screen .logo img {
	filter: drop-shadow(0px 10px 6px rgba(0, 0, 0, 0.2))
}

#fuse-splash-screen .spinner-wrapper {
	display: block;
	position: relative;
	width: 100%;
	min-height: 100px;
	height: 100px;
}

#fuse-splash-screen .spinner-wrapper .spinner {
	position: absolute;
	overflow: hidden;
	left: 50%;
	margin-left: -50px;
	animation: outer-rotate 2.91667s linear infinite;
}

#fuse-splash-screen .spinner-wrapper .spinner .inner {
	width: 100px;
	height: 100px;
	position: relative;
	animation: sporadic-rotate 5.25s cubic-bezier(0.35, 0, 0.25, 1) infinite;
}

#fuse-splash-screen .spinner-wrapper .spinner .inner .gap {
	position: absolute;
	left: 49px;
	right: 49px;
	top: 0;
	bottom: 0;
	border-top: 10px solid;
	box-sizing: border-box;
}

#fuse-splash-screen .spinner-wrapper .spinner .inner .left,
	#fuse-splash-screen .spinner-wrapper .spinner .inner .right {
	position: absolute;
	top: 0;
	height: 100px;
	width: 50px;
	overflow: hidden;
}

#fuse-splash-screen .spinner-wrapper .spinner .inner .left .half-circle,
	#fuse-splash-screen .spinner-wrapper .spinner .inner .right .half-circle
	{
	position: absolute;
	top: 0;
	width: 100px;
	height: 100px;
	box-sizing: border-box;
	border: 10px solid #4285F4;
	border-bottom-color: transparent;
	border-radius: 50%;
}

#fuse-splash-screen .spinner-wrapper .spinner .inner .left {
	left: 0;
}

#fuse-splash-screen .spinner-wrapper .spinner .inner .left .half-circle
	{
	left: 0;
	border-right-color: transparent;
	animation: left-wobble 1.3125s cubic-bezier(0.35, 0, 0.25, 1) infinite;
	-webkit-animation: left-wobble 1.3125s cubic-bezier(0.35, 0, 0.25, 1)
		infinite;
}

#fuse-splash-screen .spinner-wrapper .spinner .inner .right {
	right: 0;
}

#fuse-splash-screen .spinner-wrapper .spinner .inner .right .half-circle
	{
	right: 0;
	border-left-color: transparent;
	animation: right-wobble 1.3125s cubic-bezier(0.35, 0, 0.25, 1) infinite;
	-webkit-animation: right-wobble 1.3125s cubic-bezier(0.35, 0, 0.25, 1)
		infinite;
}

@
keyframes outer-rotate { 0% {
	transform: rotate(0deg) scale(0.5);
}

100%
{
transform


:

 

rotate


(360
deg
)

 

scale


(0
.5


);
}
}
@
keyframes left-wobble { 0%, 100% {
	transform: rotate(130deg);
}

50%
{
transform


:

 

rotate


(-5
deg
);


            

}
}
@
keyframes right-wobble { 0%, 100% {
	transform: rotate(-130deg);
}

50%
{
transform


:

 

rotate


(5
deg
);


            

}
}
@
keyframes sporadic-rotate { 12.5% {
	transform: rotate(135deg);
}
25%
{
transform


:

 

rotate


(270
deg
);


            

}
37
.5
 
%
{
transform
:
 
rotate
(405deg);


}
50%
{
transform


:

 

rotate


(540
deg
);


            

}
62
.5
 
%
{
transform
:
 
rotate
(675deg);


}
75%
{
transform


:

 

rotate


(810
deg
);


            

}
87
.5
 
%
{
transform
:
 
rotate
(945deg);


}
100%
{
transform


:

 

rotate


(1080
deg
);


            

}
}
</style>
<!-- / FUSE Splash Screen CSS -->
<link rel="stylesheet" href="ShuraIntegrationAPI/resources/styles.css">
</head>
<body>
	
	<!-- FUSE Splash Screen -->
	<fuse-splash-screen id="fuse-splash-screen">

	<div class="center">

		<div class="logo">
			<img width="128" src="ShuraIntegrationAPI/resources/assets/images/logos/shura.svg">
		</div>

		<!-- Material Design Spinner -->
		<div class="spinner-wrapper">
			<div class="spinner">
				<div class="inner">
					<div class="gap"></div>
					<div class="left">
						<div class="half-circle"></div>
					</div>
					<div class="right">
						<div class="half-circle"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- / Material Design Spinner -->

	</div>

	</fuse-splash-screen>
	<!-- / FUSE Splash Screen -->

	<app></app>

	<script type="text/javascript"
		src="ShuraIntegrationAPI/resources/runtime.js"></script>
	<script type="text/javascript"
		src="ShuraIntegrationAPI/resources/polyfills.js"></script>
	<script type="text/javascript"
		src="ShuraIntegrationAPI/resources/main.js"></script>
</body>
</html>