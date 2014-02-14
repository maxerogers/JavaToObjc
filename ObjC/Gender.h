//
//  Gender.h
//  JavaToObjC
//
//  Created by Max Rogers on 2/10/14.
//  Copyright (c) 2014 Max Rogers. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol Gender <NSObject>
-(BOOL) isMale;
-(BOOL) isFemale;
-(NSString *) gender;
@end
