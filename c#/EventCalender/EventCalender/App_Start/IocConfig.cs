using System.Web.Http;
using EventCalender.Data;
using EventCalender.Data.DomainClasses;
using SimpleInjector;
using SimpleInjector.Integration.Web;
using SimpleInjector.Integration.WebApi;

namespace EventCalender
{
    public class IocConfig
    {
        internal static void RegisterDependencies()
        {
            RegisterApiDependencies();
        }

        private static void RegisterApiDependencies()
        {
            var apiContainer = new Container();
            
            apiContainer.Options.DefaultScopedLifestyle = new WebRequestLifestyle();
            apiContainer.Register<IEventRepository, EventDbRepository>(Lifestyle.Scoped);
            apiContainer.Register<IUserRepository, UserDbRepository>(Lifestyle.Scoped);
            apiContainer.Register<EventCalenderContext>(() => new EventCalenderContext(), Lifestyle.Scoped);
            
            apiContainer.Verify();
            
            GlobalConfiguration.Configuration.DependencyResolver = new SimpleInjectorWebApiDependencyResolver(apiContainer);
        }
        
    }
}