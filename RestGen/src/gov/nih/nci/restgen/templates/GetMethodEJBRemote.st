	@GET
	@Path("$PathParamPath$")
	@Produces("application/xml")
	public $ReturnType$ get$MethodName$($PathParam$, @Context UriInfo uriInfo)
	{
		try
		{
			List<PathSegment> pathSegments = uriInfo.getPathSegments();
			Map matrixParams = pathSegments.get(1).getMatrixParameters();
			String[] paramNames = {$ParamNames$};
			//validateCriteria("$ResourceName$", matrixParams, paramNames);

	        $HomeInterface$ ejbHome; 
	        $RemoteInterface$ ejbRemote;
	 
	        Properties props = new Properties();
			props.load(new FileInputStream("$JNDIProperties$"));
	
	        InitialContext initContext = null; 
	
	        try { 
	            initContext = new javax.naming.InitialContext(props); 
	            Object objref = initContext.lookup("$JNDIName$"); 
	            ejbHome = ($HomeInterface$)PortableRemoteObject.narrow(objref,
	                                             $HomeInterface$.class);
	            ejbRemote = ejbHome.create();  
				return ejbRemote.$OperationName$($OperationParameters$);
	        }  
	        catch(CreateException e) {
	        	e.printStackTrace();
				ResponseBuilder builder = Response.status(Status.BAD_REQUEST);
				builder.type("application/xml");
				StringBuffer buffer = new StringBuffer();
				buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				buffer.append("<response>");
				buffer.append("<type>ERROR</type>");
				buffer.append("<code>GET_EJB_LOCAL_1</code>");
				buffer.append("<resource>$ResourceName$</resource>");
				buffer.append("<path>GET</path>");
				buffer.append("<message>Failed to create local client for EJB: "+ e.getMessage() + "</message>");
				buffer.append("</response>");
				builder.entity(buffer.toString());
				throw new WebApplicationException(builder.build());
	        }  
	        catch(RemoteException e) {
	        	e.printStackTrace();
				ResponseBuilder builder = Response.status(Status.BAD_REQUEST);
				builder.type("application/xml");
				StringBuffer buffer = new StringBuffer();
				buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				buffer.append("<response>");
				buffer.append("<type>ERROR</type>");
				buffer.append("<code>GET_EJB_LOCAL_1</code>");
				buffer.append("<resource>$ResourceName$</resource>");
				buffer.append("<path>GET</path>");
				buffer.append("<message>Failed to create local client for EJB: "+ e.getMessage() + "</message>");
				buffer.append("</response>");
				builder.entity(buffer.toString());
				throw new WebApplicationException(builder.build());
	        }  
	        catch (Exception e) { 
	        	e.printStackTrace();
				ResponseBuilder builder = Response.status(Status.BAD_REQUEST);
				builder.type("application/xml");
				StringBuffer buffer = new StringBuffer();
				buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				buffer.append("<response>");
				buffer.append("<type>ERROR</type>");
				buffer.append("<code>GET_EJB_LOCAL_1</code>");
				buffer.append("<resource>$ResourceName$</resource>");
				buffer.append("<path>GET</path>");
				buffer.append("<message>Failed to create local client for EJB: "+ e.getMessage() + "</message>");
				buffer.append("</response>");
				builder.entity(buffer.toString());
				throw new WebApplicationException(builder.build());
	        } 
		}
		$ResourceException; separator="\n"$
		catch(WebApplicationException e)
		{
			e.printStackTrace();
			throw e;
		}
	}