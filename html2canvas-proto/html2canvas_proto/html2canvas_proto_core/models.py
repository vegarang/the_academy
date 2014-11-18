from django.db import models


class CanvasTest(models.Model):
    image = models.ImageField(upload_to='canvas/')
