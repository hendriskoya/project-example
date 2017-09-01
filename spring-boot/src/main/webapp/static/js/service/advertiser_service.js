'use strict';

App.factory('AdvertiserService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllAdvertisers: function() {
					return $http.get('/Spring4MVCAngularJSExample/api/advertiser/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching advertisers');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createAdvertiser: function(advertiser){
					return $http.post('/Spring4MVCAngularJSExample/api/advertiser/', advertiser)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating advertiser');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateAdvertiser: function(advertiser, id){
					return $http.put('/Spring4MVCAngularJSExample/api/advertiser/'+id, advertiser)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating advertiser');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteAdvertiser: function(id){
					return $http.delete('/Spring4MVCAngularJSExample/api/advertiser/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting advertiser');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
