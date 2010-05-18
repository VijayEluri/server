
/*
 * DashBoard handles the HTML and CSS setup of a users' dashboard.
 * The DashBoard reads in a local or remote JSON configuration, and
 * loads a dashboard based on the contents of the configuration.
 */

// DashBoard consturctor
function DashBoard() {
	this.cur_view = null;
	this.userName = "";
	this.userRole = 0;
}

// Logger for the dashboard
DashBoard._logger = log4javascript.getLogger();

// The various DashBoads views
DashBoard.view_type = {
    "VIEW_GRAPH":0,
    "VIEW_UPLOAD":1,
    "VIEW_INFO":2
};

// Dashboard functions

DashBoard.prototype.set_user_name = function(userName) {
	this.userName = userName;
}

// Switch dashboard view
DashBoard.prototype.switch_view = function(new_view) {
	// Check to be sure the new view exists
	//if (!new_view in DashBoard.view_type) {
	//	throw new Error(new_view + ' is not a defined view type.');
	//}
	
	// Clear out the old view and insert the new
	this.unload_view();
	
	// Update the banner with the new view
	this.switch_banner(new_view);
	
	switch (new_view) {
	case DashBoard.view_type.VIEW_GRAPH:
		this.cur_view = new ViewGraph();
		break;
	case DashBoard.view_type.VIEW_UPLOAD:
		this.cur_view = new ViewUpload();
		break;
	}
}


// Unload a view and return the dashboard to a default state
DashBoard.prototype.unload_view = function() {
	// Implement this
	
	this.cur_view = null;
}

// Setup the HTML and CSS according to the configuration JSON.
DashBoard.prototype.configure_html = function(json_config) {
	// Be sure the View is loaded correctly
	this.check_view();
	
	// Send the json_config to the view
	this.cur_view.configure_html(json_config);
}

// Load new data into the dashboard
DashBoard.prototype.pass_data = function(aw_data) {
	if (DashBoard._logger.isDebugEnabled()) {
        DashBoard._logger.debug("DashBoard.pass_data(): Passed data of type: ");
    }
	
	// Be sure a View is currently loaded
	this.check_view();
	
	// Send the data to the view
	this.cur_view.load_data(aw_data);
	
	// Turn off the views loading graphic if applicable
	this.cur_view.loading(false);
}

// Enable/disable the loading graphic
DashBoard.prototype.loading = function(enable) {
	// Be sure the View is loaded correctly
	this.check_view();
	
	// Tell the current view the new loading status
	this.cur_view.loading(enable);
}

DashBoard.prototype.check_view = function() {
	if (this.cur_view == null) {
		throw new Error('DashBoard: A view is not loaded.');
	}
}

/*
 * Functions to handle the Header.  Move these to their own module eventually.
 */
DashBoard.prototype.initialize_banner = function() {
	$('#banner').append('<span class="h banner_text">EMA Visualizations for ' + this.userName + '.</span><br>')
		        .append('<div id="logout"><a href="/app/logout">Logout</a></div>');
}

DashBoard.prototype.switch_banner = function(view_type) {
	
}

