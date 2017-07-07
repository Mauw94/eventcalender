using System.Data.Entity.Migrations;
using EventCalender.Data.DomainClasses;

namespace EventCalender.Data.migrations
{
    internal sealed class Configuration : DbMigrationsConfiguration<EventCalenderContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
        }

        protected override void Seed(EventCalenderContext context)
        {
            //  This method will be called after migrating to the latest version.
            var test = new Event
            {
                Subject = "Test123",
                Note = "Empty",
                Description = "Empty",
                Id = 1,
                Date = "Empty",
                Time = "Empty"
            };
            context.Events.AddOrUpdate(r => r.Subject, test);

            context.SaveChanges();

        }
    }
}
