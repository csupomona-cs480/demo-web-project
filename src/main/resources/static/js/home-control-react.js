class UserList extends React.Component {
  constructor(props) {
    super(props);

    this.state = {users: []};
  }

  componentDidMount() {
    this.UserList();
  }

  UserList() {
    return $.getJSON('cs480/users/list')
      .then((data) => {
        this.setState({ users: data });
      });
  }

  deleteUser(userId) {
  	console.log("deleting user id: " + userId);
  	$.ajax(
			{
				type : "DELETE",
				url  : "/cs480/user/" + userId,
				data : {
				},
				success : function(result) {
					this.componentDidMount();
				},
				error: function (jqXHR, exception) {
					alert("Failed to delete the user.");
				}
			});
  }
  
  render() {
    const userlist = this.state.users && this.state.users.length > 0 ? this.state.users.map((user, i) => {
    	  return <tbody>
	                <tr>
	                    <td>{user.id}</td>
	                    <td>{user.name}</td>
	                    <td>{user.major}</td>
	                    <td>{user.creationTime}</td>
                        <td><button onClick={() => this.deleteUser(user.id)}>Delete</button></td>
	                </tr>
	        </tbody>
    }) : (null);

    return
    	  <div> 
    		  <div>
    	  			<label>User List</label>
	            <table border="1">
	                <tr>
	                    <td>ID</td>
	                    <td>Name</td>
	                    <td>Major</td>
	                    <td>Creation Time</td>
	                    <td>Delete</td>
	                </tr>

	                { userlist }
	            </table>      
    		   </div>
    		   
    		   <hr/>

	       <div>
	            <label>Add User</label>
	            <table border="1">
	                <tr>
	                    <td>ID</td>
	                    <td>Name</td>
	                    <td>Major</td>
	                    <td>Add</td>
	                </tr>
	                <tr>
	                    <td><input type="text" ng-model="new_id"/></td>
	                    <td><input type="text" ng-model="new_name"/></td>
	                    <td><input type="text" ng-model="new_major"/></td>
	                    <td><button onClick={() => this.addUser()}>Add</button></td>
	                </tr>
	            </table>
	       </div>
      </div>
  }
}

ReactDOM.render(
	<UserList />, 
	document.getElementById('root')
);
