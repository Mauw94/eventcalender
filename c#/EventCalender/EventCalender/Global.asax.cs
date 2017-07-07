using System.Web;
using System.Web.Mvc;
using System.Web.Routing;
using System.Web.Http;
using EventCalender.Data;

namespace EventCalender
{
    public class Global : HttpApplication
    {
        protected void Application_Start()
        {
            IocConfig.RegisterDependencies();
            AreaRegistration.RegisterAllAreas();
            GlobalConfiguration.Configure(WebApiConfig.Register);
            RouteConfig.RegisterRoutes(RouteTable.Routes);
            EventCalenderContext.SetInitializer();
        }
    }
}