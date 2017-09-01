'use strict';

App.controller('AdvertiserController', ['$scope', 'AdvertiserService', function($scope, AdvertiserService) {
          var self = this;
          self.advertiser={id:null,name:'',email:''};
          self.advertisers=[];
              
          self.fetchAllAdvertisers = function(){
              AdvertiserService.fetchAllAdvertisers()
                  .then(
      					       function(d) {
      						        self.advertisers = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching advertisers');
            					}
      			       );
          };
           
          self.createAdvertiser = function(advertiser){
              AdvertiserService.createAdvertiser(advertiser)
		              .then(
                      self.fetchAllAdvertisers, 
				              function(errResponse){
					               console.error('Error while creating advertiser.');
				              }	
                  );
          };

         self.updateAdvertiser = function(advertiser, id){
              AdvertiserService.updateAdvertiser(advertiser, id)
		              .then(
				              self.fetchAllAdvertisers, 
				              function(errResponse){
					               console.error('Error while updating Advertiser.');
				              }	
                  );
          };

         self.deleteAdvertiser = function(id){
              AdvertiserService.deleteAdvertiser(id)
		              .then(
				              self.fetchAllAdvertisers, 
				              function(errResponse){
					               console.error('Error while deleting Advertiser.');
				              }	
                  );
          };

          self.fetchAllAdvertisers();

          self.submit = function() {
              if(self.advertiser.id==null){
                  console.log('Saving New Advertiser', self.advertiser);    
                  self.createAdvertiser(self.advertiser);
              }else{
                  self.updateAdvertiser(self.advertiser, self.advertiser.id);
                  console.log('Advertiser updated with id ', self.advertiser.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.advertisers.length; i++){
                  if(self.advertisers[i].id == id) {
                     self.advertiser = angular.copy(self.advertisers[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.advertiser.id === id) {//clean form if the advertiser to be deleted is shown there.
                 self.reset();
              }
              self.deleteAdvertiser(id);
          };

          
          self.reset = function(){
              self.advertiser={id:null,name:'',email:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
