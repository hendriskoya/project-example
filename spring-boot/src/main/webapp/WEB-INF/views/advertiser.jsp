<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS $http Example</title>
  </head>
  <body ng-app="myApp">

	<div ng-controller="AdvertiserController as ctrl">
  
    <form ng-submit="ctrl.submit()" name="myForm">
        <input type="hidden" ng-model="ctrl.advertiser.id" />
        <label>Name</label>
        <div>
            <input type="text" ng-model="ctrl.advertiser.name" name="name" placeholder="Enter your name" required ng-minlength="3"/>
            <div ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">This is a required field</span>
                <span ng-show="myForm.name.$error.minlength">Minimum length required is 3</span>
                <span ng-show="myForm.name.$invalid">This field is invalid </span>
            </div>
        </div>
        
        <label class="col-md-2 control-lable" for="file">Email</label>
        <div>
            <input type="email" ng-model="ctrl.advertiser.email" name="email" placeholder="Enter your Email" required/>
            <div ng-show="myForm.$submitted || myForm.email.$touched">
                <span ng-show="myForm.email.$error.required">This is a required field</span>
                <span ng-show="myForm.email.$error.email">This field is invalid </span>
            </div>
        </div>
        
        <div>
            <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" ng-disabled="myForm.$invalid">
            <button type="button" ng-click="ctrl.reset()" ng-disabled="myForm.$pristine">Reset Form</button>
        </div>
    </form>
    
              <span>List of Users </span>
                 <table>
                     <thead>
                         <tr>
                             <th>ID.</th>
                             <th>Name</th>
                             <th>Email</th>
                             <th width="20%"></th>
                         </tr>
                     </thead>
                     <tbody>
                         <tr ng-repeat="u in ctrl.advertisers">
                             <td><span ng-bind="u.id"></span></td>
                             <td><span ng-bind="u.name"></span></td>
                             <td><span ng-bind="u.email"></span></td>
                             <td>
                             <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  
                             <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                             </td>
                         </tr>
                     </tbody>
                 </table>
    
    </div>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/advertiser_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/advertiser_controller.js' />"></script>
      
  </body>
</html>