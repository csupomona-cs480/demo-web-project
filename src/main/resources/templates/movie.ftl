<html>

<head>
    <title>CS480 Demo Web Service</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/home-control.js"></script>
</head>

<body>    
    


    <div>
        <div>
            
            <table border="1">            
                <tr>
                    
                    <td>Name</td> 
                    <td>Image</td>
                </tr>
                <#list movies as m>
                        <tr>
                    
                            <td>${m.name}</td>
                            <td><img src="${m.imgUrl}"></img></td>
                        </tr>
                </#list>
            </table>
        </div>
        
     </div>
    
    
</body>

</html>