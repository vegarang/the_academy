from django.db import models


class CanvasTest(models.Model):
    image = models.ImageField(upload_to='canvas/')
    title = models.CharField(max_length=256, null=True, blank=True)
    description = models.TextField(null=True, blank=True)
