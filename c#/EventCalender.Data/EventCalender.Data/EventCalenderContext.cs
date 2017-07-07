using System.Data.Entity;
using EventCalender.Data.DomainClasses;

namespace EventCalender.Data
{
    public class EventCalenderContext : DbContext
    {
        public EventCalenderContext() : base("EventCalender")
        {
            
        }
        
        public DbSet<Event> Events { get; set; }
        public DbSet<User> users { get; set; }

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