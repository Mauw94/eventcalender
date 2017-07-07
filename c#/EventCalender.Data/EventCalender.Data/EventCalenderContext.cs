using System.Data.Entity;
using EventCalender.Data.DomainClasses;
using EventCalender.Data.migrations;
using Microsoft.AspNet.Identity.EntityFramework;

namespace EventCalender.Data
{
    public class EventCalenderContext : IdentityDbContext<ApplicationUser>
    {
        public EventCalenderContext() : base("EventCalender")
        {
            
        }
        
        public DbSet<Event> Events { get; set; }
        public DbSet<User> Users { get; set; }

        public static EventCalenderContext Create()
        {
            return new EventCalenderContext();
        }
        
        public static void SetInitializer()
        {
            Database.SetInitializer(new MigrateDatabaseToLatestVersion<EventCalenderContext, Configuration>());
        }
    }
}