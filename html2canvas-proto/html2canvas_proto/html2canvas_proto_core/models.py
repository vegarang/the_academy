from django.db import models


class CanvasTest(models.Model):
    image = models.ImageField(upload_to='canvas/')
    title = models.CharField(max_length=256, null=True, blank=True)
    username = models.CharField(max_length=256, null=True, blank=True)
    url = models.CharField(max_length=256, null=True, blank=True)
    description = models.TextField(null=True, blank=True)


class SimpleUser(models.Model):
    username = models.CharField(max_length=256, null=True, blank=False)

    def __unicode__(self):
        return u'{}'.format(self.__str__)

    def __str__(self):
        return self.username